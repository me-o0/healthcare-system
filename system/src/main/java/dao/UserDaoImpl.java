package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.User;
import utils.DatabaseUtils;

public class UserDaoImpl implements UserDao {

	 @Override
	    public String getUserPassword(String username) {
	        String sql = "SELECT password FROM users WHERE username = ?";
	        try (Connection connection = DatabaseUtils.getConnection();
	             PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, username);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    String password = rs.getString("password");
	                    System.out.println("Retrieved password: " + password); // パスワードの確認
	                    return password;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null; // パスワードが見つからない場合
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
	            statement.setString(2, password); // ここではハッシュ化せず、呼び出し元でハッシュ化する
	            statement.setString(3, email);

	            int rowsInserted = statement.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
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

	                    Timestamp lockTime = rs.getTimestamp("lock_time");
	                    if (lockTime != null) {
	                        user.setLockTime(lockTime.toLocalDateTime());
	                    }

	                    user.setResetToken(rs.getString("reset_token"));

	                    Timestamp resetTokenExpiry = rs.getTimestamp("reset_token_expiry");
	                    if (resetTokenExpiry != null) {
	                        user.setResetTokenExpiry(resetTokenExpiry.toLocalDateTime());
	                    }

	                    user.setRole(rs.getString("role"));

	                    Timestamp createdAt = rs.getTimestamp("created_at");
	                    if (createdAt != null) {
	                        user.setCreatedAt(createdAt.toLocalDateTime());
	                    }

	                    Timestamp updatedAt = rs.getTimestamp("updated_at");
	                    if (updatedAt != null) {
	                        user.setUpdatedAt(updatedAt.toLocalDateTime());
	                    }

	                    Timestamp lastLogin = rs.getTimestamp("last_login");
	                    if (lastLogin != null) {
	                        user.setLastLogin(lastLogin.toLocalDateTime());
	                    }

	                    return user;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;  // ユーザーが見つからない場合
	    }
}