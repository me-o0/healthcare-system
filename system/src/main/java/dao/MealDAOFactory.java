package dao;

public class MealDAOFactory {

    // MealDAOのインスタンスを取得するメソッド
    public static MealDAO getMealDAO() {
        // 必要に応じてDAOの実装を切り替えることもできる
        // 例えば、JDBCの場合とORM（例：Hibernate）の場合で異なる実装を返すことができます
        return new MealDAOImpl();  // 現在はMealDAOImplを返す
    }
}

