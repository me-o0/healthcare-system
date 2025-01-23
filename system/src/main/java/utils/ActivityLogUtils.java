package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActivityLogUtils {

    // ユーザーアクションをログに記録
    public static void logActivity(String username, String action, String ipAddress) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            String sql = "INSERT INTO activity_log (user_id, action, ip_address) SELECT id, ?, ? FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, action);
            statement.setString(2, ipAddress);
            statement.setString(3, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

