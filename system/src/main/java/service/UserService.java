package service;

import dao.UserDaoImpl;
import model.User;
import utils.PasswordUtils;

public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();  // UserDaoを初期化
    }

    // ログイン処理
    public boolean login(String username, String password) {
        // ユーザーのハッシュ化されたパスワードをデータベースから取得
        String storedPassword = userDao.getUserPassword(username);

        // パスワードが存在しない場合はエラー
        if (storedPassword == null || storedPassword.isEmpty()) {
            throw new IllegalArgumentException("ユーザーのパスワードが存在しません");
        }

        // ユーザーが入力したパスワードが空かどうかを確認
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("パスワードは空であってはいけません");
        }

        // パスワードとハッシュ化されたパスワードを照合
        boolean isPasswordValid = PasswordUtils.verifyPassword(password, storedPassword);
        System.out.println("Password valid: " + isPasswordValid);  // デバッグ用

        // ハッシュ化されたパスワードが一致した場合、ログイン成功
        if (isPasswordValid) {
            User user = userDao.getUserByUsername(username);
            if (user != null && !user.isAccountLocked()) {
                return true;  // ログイン成功
            }
        }
        return false;  // ログイン失敗
    }



    // ユーザー情報を取得
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    // アカウント登録処理
    public boolean register(String username, String password, String email) {
        // ユーザーが既に存在するか確認
        if (userDao.checkIfUserExists(username)) {
            return false; // ユーザーが既に存在する
        }
        
        // パスワードをハッシュ化
        String hashedPassword = PasswordUtils.hashPassword(password);
        
        // 新しいユーザーを作成
        return userDao.createUser(username, hashedPassword, email);
    }



    // ログイン履歴を保存
    public boolean saveLoginHistory(int userId, String ipAddress, String status) {
        return userDao.saveLoginHistory(userId, ipAddress, status);
    }

    // アカウントロック状態を確認
    public boolean isAccountLocked(String username) {
        return userDao.isAccountLocked(username);
    }

    // 失敗したログイン試行をリセット
    public boolean resetFailedAttempts(String username) {
        return userDao.resetFailedAttempts(username);
    }
}









