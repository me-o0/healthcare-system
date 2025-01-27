package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseUtils {

    // Tomcatの接続プールからConnectionを取得
    public static Connection getConnection() throws SQLException {
        try {
            // JNDIを使ってDataSourceを取得
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/healthcare_system_db");
            return dataSource.getConnection();
        } catch (NamingException e) {
            throw new SQLException("データベース接続プールの取得に失敗しました", e);
        }
    }
}



