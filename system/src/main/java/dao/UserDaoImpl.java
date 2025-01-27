package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import utils.DatabaseUtils;

public class UserDaoImpl implements UserDao {

    @Override
    public String getUserPassword(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkIfUserExists(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT 1 FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isAccountLocked(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT account_locked FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBoolean("account_locked");
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean incrementFailedAttempts(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET failed_attempts = failed_attempts + 1 WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createUser(String username, String password, String email) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO users (username, password, email, created_at, updated_at, account_locked, failed_attempts) VALUES (?, ?, ?, NOW(), NOW(), 0, 0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, BCrypt.hashpw(password, BCrypt.gensalt())); // パスワードをハッシュ化
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String generateResetToken(String email) {
        String resetToken = UUID.randomUUID().toString();

        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET reset_token = ?, reset_token_expiry = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, resetToken);
            Timestamp expiryTime = new Timestamp(System.currentTimeMillis() + 60 * 60 * 1000);  // 1時間後の期限
            statement.setTimestamp(2, expiryTime);
            statement.setString(3, email);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return resetToken;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "SELECT 1 FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setUserRole(int userId, String role) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET role = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, role);
            statement.setInt(2, userId);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveLoginHistory(int userId, String ipAddress, String status) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO login_history (user_id, ip_address, status) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, ipAddress);
            statement.setString(3, status);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    @Override
    public boolean resetFailedAttempts(String username) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "UPDATE users SET failed_attempts = 0 WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT id, username, email, account_locked, failed_attempts, lock_time, reset_token, reset_token_expiry, role, created_at, updated_at, last_login FROM users WHERE username = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setAccountLocked(rs.getBoolean("account_locked"));
                    user.setFailedAttempts(rs.getInt("failed_attempts"));
                    user.setLockTime(rs.getTimestamp("lock_time").toLocalDateTime());
                    user.setResetToken(rs.getString("reset_token"));
                    user.setResetTokenExpiry(rs.getTimestamp("reset_token_expiry").toLocalDateTime());
                    user.setRole(rs.getString("role"));
                    user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    user.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                    user.setLastLogin(rs.getTimestamp("last_login").toLocalDateTime());
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // ユーザーが見つからない場合
    }
}

