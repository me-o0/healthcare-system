package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    // データベース接続を取得するメソッド
    public static Connection getConnection() throws SQLException {
        // データベース接続のURL、ユーザー名、パスワードを指定
        String url = "jdbc:mysql://127.0.0.1:3306/healthcare_system_db";  // データベースURL
        String username = "root";  // ユーザー名
        String password = "";  // パスワード

        try {
            // JDBCドライバを手動でロードする
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBCドライバーのロードに失敗しました: " + e.getMessage(), e);
        }
    }
}
