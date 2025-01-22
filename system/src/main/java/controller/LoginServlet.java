package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final int MAX_FAILED_ATTEMPTS = 5;  // ログイン試行回数の制限
    private static final long LOCK_TIME = 15 * 60 * 1000;  // ロック時間（15分）

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password")) {
            // ユーザーの情報をデータベースから取得
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // ロック状態かチェック
                    boolean isLocked = rs.getBoolean("is_locked");
                    Timestamp lockedUntil = rs.getTimestamp("locked_until");

                    if (isLocked && lockedUntil.after(new Timestamp(System.currentTimeMillis()))) {
                        response.getWriter().write("Account is locked. Try again later.");
                        return;
                    }

                    // パスワードを照合
                    String hashedPassword = rs.getString("password");
                    if (org.mindrot.jbcrypt.BCrypt.checkpw(password, hashedPassword)) {
                        // ログイン成功
                        response.getWriter().write("Login successful!");
                        resetFailedAttempts(username, connection);
                    } else {
                        // ログイン失敗
                        incrementFailedAttempts(username, connection);
                        response.getWriter().write("Invalid username or password.");
                    }
                } else {
                    response.getWriter().write("User not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ログイン失敗回数をインクリメント
    private void incrementFailedAttempts(String username, Connection connection) throws SQLException {
        String sql = "SELECT failed_attempts, last_failed_attempt FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int failedAttempts = rs.getInt("failed_attempts");
                Timestamp lastFailedAttempt = rs.getTimestamp("last_failed_attempt");

                // 失敗回数が制限を超えている場合はロック
                if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                    Timestamp lockTime = new Timestamp(System.currentTimeMillis() + LOCK_TIME);
                    String lockSql = "UPDATE users SET is_locked = true, locked_until = ? WHERE username = ?";
                    try (PreparedStatement lockStmt = connection.prepareStatement(lockSql)) {
                        lockStmt.setTimestamp(1, lockTime);
                        lockStmt.setString(2, username);
                        lockStmt.executeUpdate();
                    }
                } else {
                    // 失敗回数をインクリメント
                    String updateSql = "UPDATE users SET failed_attempts = ?, last_failed_attempt = NOW() WHERE username = ?";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, failedAttempts + 1);
                        updateStmt.setString(2, username);
                        updateStmt.executeUpdate();
                    }
                }
            }
        }
    }

    // 失敗回数をリセット
    private void resetFailedAttempts(String username, Connection connection) throws SQLException {
        String sql = "UPDATE users SET failed_attempts = 0, last_failed_attempt = NULL WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }
}


