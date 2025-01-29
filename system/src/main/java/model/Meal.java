package model;

import java.sql.Timestamp;
import java.util.List;

public class Meal {
    private int mealId;
    private int userId;
    private String mealType;
    private Timestamp mealTime;  // Timestamp型
    private String mealSource;
    private String notes;
    private List<MealFood> mealFoods;  // 食品とその量を保持するリスト
    private String mealDate;  // meal_date 用のフィールドを追加

    // コンストラクタ
    public Meal() {}

    // Getters and Setters
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Timestamp getMealTime() {
        return mealTime;
    }

    public void setMealTime(Timestamp mealTime) {
        this.mealTime = mealTime;
    }

    public String getMealSource() {
        return mealSource;
    }

    public void setMealSource(String mealSource) {
        this.mealSource = mealSource;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<MealFood> getMealFoods() {
        return mealFoods;
    }

    public void setMealFoods(List<MealFood> mealFoods) {
        this.mealFoods = mealFoods;
    }

    // mealDate の getter と setter を追加
    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }
}



