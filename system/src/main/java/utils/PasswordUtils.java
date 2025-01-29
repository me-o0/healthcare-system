package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // パスワードをハッシュ化
    public static String hashPassword(String plainPassword) {
        if (plainPassword == null || plainPassword.isEmpty()) {
            throw new IllegalArgumentException("パスワードは空であってはいけません");
        }
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // パスワードを検証
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || plainPassword.isEmpty() || hashedPassword == null || hashedPassword.isEmpty()) {
            throw new IllegalArgumentException("パスワードとハッシュされたパスワードは空であってはいけません");
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}

