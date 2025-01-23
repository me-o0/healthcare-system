package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import utils.DatabaseUtils;

public class UserDao {

    // ユーザーのパスワードを取得する
    public String getUserPassword(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }
            return null; // ユーザーが見つからない場合
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // エラー発生時
        }
    }

    // ユーザーが存在するか確認する
    public boolean checkIfUserExists(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT 1 FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // ユーザーが存在する場合は true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // アカウントがロックされているか確認する
    public boolean isAccountLocked(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT account_locked FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBoolean("account_locked");
            }
            return false; // ユーザーが見つからない場合
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // 失敗したログイン試行回数をインクリメントする
    public boolean incrementFailedAttempts(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET failed_attempts = failed_attempts + 1 WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // 更新が成功した場合
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // ユーザーを新規作成する
    public boolean createUser(String username, String password, String email) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO users (username, password, email, created_at, updated_at, account_locked, failed_attempts) VALUES (?, ?, ?, NOW(), NOW(), 0, 0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password); // パスワードは事前にハッシュ化するべき
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // 登録が成功した場合
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // パスワードリセット用のトークンを生成して保存する
    public String generateResetToken(String email) {
        String resetToken = UUID.randomUUID().toString();  // 一意のトークンを生成

        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET reset_token = ?, reset_token_expiry = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, resetToken);

            // トークンの有効期限を1時間後に設定
            Timestamp expiryTime = new Timestamp(System.currentTimeMillis() + 60 * 60 * 1000);  // 1時間後
            statement.setTimestamp(2, expiryTime);
            statement.setString(3, email);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return resetToken;  // トークンが正常に生成され、保存された場合
            } else {
                return null;  // ユーザーが見つからない場合
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;  // エラー発生時
        }
    }

    // パスワードリセットトークンを生成する（引数なし）
    public String generatePasswordResetToken() {
        return UUID.randomUUID().toString();  // 新しいリセットトークンを生成
    }

    // メールアドレスが既に存在するか確認する
    public boolean checkIfEmailExists(String email) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT 1 FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // メールアドレスが存在する場合は true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // ユーザーの役割を設定するメソッド（役割管理用）
    public boolean setUserRole(int userId, String role) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET role = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, role);
            statement.setInt(2, userId);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // 役割が正常に更新された場合
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }

    // ログイン履歴を保存するメソッド
    public boolean saveLoginHistory(int userId, String ipAddress, String status) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO login_history (user_id, ip_address, status) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, ipAddress);
            statement.setString(3, status);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // 履歴が正常に保存された場合
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー発生時
        }
    }
}






