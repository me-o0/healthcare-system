package model;

import java.sql.Timestamp;

public class MealFood {
    private int mealFoodId;
    private int mealId;
    private int foodId;
    private double quantity;
    private Timestamp mealDate;  // 日付を追加

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

    public Timestamp getMealDate() {
        return mealDate;
    }

    public void setMealDate(Timestamp mealDate) {
        this.mealDate = mealDate;
    }
}
