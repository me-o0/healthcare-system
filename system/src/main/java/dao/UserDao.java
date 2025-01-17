package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
    private final String jdbcUsername = "your_username";
    private final String jdbcPassword = "your_password";

    // ユーザーを取得する
    public String getPasswordHashByUsername(String username) {
        String query = "SELECT password_hash FROM users WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password_hash");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // ユーザーが存在しない場合
    }
}

