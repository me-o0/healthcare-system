package dao;

public class FoodDAOFactory {
    private static FoodDAO foodDAO = new FoodDAOImpl();

    public static FoodDAO getFoodDAO() {
        return foodDAO;
    }
}

