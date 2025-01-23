package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // パスワードをハッシュ化
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // パスワードを検証
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}


