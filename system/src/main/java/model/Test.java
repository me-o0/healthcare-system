package model;

import utils.PasswordUtils;

public class Test {

    public static void main(String[] args) {
        String plainPassword = "o"; // ユーザーが入力したパスワード
        String hashedPassword = "$2a$10$kaq18V15JDQPyeWWOVTsUOlPXD9Z1QAo4uITNfHZVp0SUWQ6ABdZu"; // データベースから取得したハッシュ値

        // パスワード照合
        boolean isPasswordValid = PasswordUtils.verifyPassword(plainPassword, hashedPassword);

        // 結果を表示
        System.out.println("Password valid: " + isPasswordValid); // true ならパスワードが正しいことを意味します
    }
}



