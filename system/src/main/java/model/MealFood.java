package model;

public class MealFood {
    private int mealFoodId;
    private int mealId;
    private int foodId;
    private double quantity;

    // コンストラクタ
    public MealFood() {}

    // Getters and Setters
    public int getMealFoodId() {
        return mealFoodId;
    }

    public void setMealFoodId(int mealFoodId) {
        this.mealFoodId = mealFoodId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

