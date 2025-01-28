package model;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImpl;
import utils.DatabaseUtils;

public class Test {

    public static void main(String[] args) {
        try (Connection connection = DatabaseUtils.getConnection()) {
            if (connection != null) {
                System.out.println("データベース接続成功");
            } else {
                System.out.println("データベース接続失敗");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDaoImpl();

        boolean userCreated = userDao.createUser("test", "test123", "test@example.com");
        if (userCreated) {
            System.out.println("ユーザー作成成功");
        } else {
            System.out.println("ユーザー作成失敗");
        }

        User user = userDao.getUserByUsername("test");
        if (user != null) {
            System.out.println("ユーザー情報: " + user.toString());
        } else {
            System.out.println("ユーザーが見つかりませんでした");
        }
    }
}

