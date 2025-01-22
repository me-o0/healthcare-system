package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // パスワードをハッシュ化する
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // パスワードを検証する
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        // サンプルパスワード
        String password = "my_secure_password";

        // ハッシュ化
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        // パスワードの検証
        boolean isPasswordValid = verifyPassword("my_secure_password", hashedPassword);
        System.out.println("Password Valid: " + isPasswordValid);
    }
}

