package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActivityLogUtils {

    // ユーザーアクションをログに記録
	public static void logActivity(String username, String action, String ipAddress) {
	    Connection connection = null;
	    try {
	        connection = DatabaseUtils.getConnection();
	        connection.setAutoCommit(false); // トランザクション開始

	        String sql = "INSERT INTO activity_log (user_id, action, ip_address) "
	                   + "SELECT id, ?, ? FROM users WHERE username = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, action);
	        statement.setString(2, ipAddress);
	        statement.setString(3, username);

	        statement.executeUpdate();
	        connection.commit(); // コミット
	    } catch (SQLException e) {
	        if (connection != null) {
	            try {
	                connection.rollback(); // エラーがあればロールバック
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.setAutoCommit(true); // 自動コミットを戻す
	                connection.close();
	            } catch (SQLException closeEx) {
	                closeEx.printStackTrace();
	            }
	        }
	    }
	}

}

