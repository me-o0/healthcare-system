package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import utils.DatabaseUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // パスワードをBCryptでハッシュ化
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // DBにユーザー情報を保存
        try (Connection conn = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, hashedPassword);
                stmt.setString(3, email);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}



