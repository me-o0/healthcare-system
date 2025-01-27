package dao;

public class DaoFactory {

    private static UserDao userDaoInstance;

    // SingletonパターンでUserDaoインスタンスを返す
    public static UserDao getUserDao() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDaoImpl(); // UserDaoImplのインスタンスを生成
        }
        return userDaoInstance;
    }

    // UserDaoImplの新しいインスタンスを生成して返す
    public static UserDao createUserDao() {
        return new UserDaoImpl(); // 常に新しいインスタンスを生成
    }
}

