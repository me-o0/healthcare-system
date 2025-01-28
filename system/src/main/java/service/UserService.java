package service;

import dao.UserDaoImpl;
import model.User;
import utils.PasswordUtils;

public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    // ログイン処理
    public boolean login(String username, String password) {
        // ユーザーのハッシュ化されたパスワードを取得
        String storedPassword = userDao.getUserPassword(username);
        
        // ハッシュ化されたパスワードと入力されたパスワードを照合
        if (storedPassword != null && PasswordUtils.verifyPassword(password, storedPassword)) {
            User user = userDao.getUserByUsername(username);
            
            // ユーザーが存在し、アカウントがロックされていない場合
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


    // パスワードリセット処理
    public String initiatePasswordReset(String email) {
        // メールが既に登録されているか確認
        if (!userDao.checkIfEmailExists(email)) {
            return null; // メールが存在しない場合
        }
        
        // リセットトークンを生成
        return userDao.generateResetToken(email);
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







