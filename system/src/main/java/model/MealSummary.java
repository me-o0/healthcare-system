package model;

import java.sql.Timestamp;

public class MealSummary {
    private Timestamp mealTime;  // mealDate を mealTime に変更
    private int totalCalories;
    private int totalProtein;
    private int totalFat;
    private int totalCarbs;

    // コンストラクタ
    public MealSummary(Timestamp mealTime, int totalCalories, int totalProtein, int totalFat, int totalCarbs) {
        this.mealTime = mealTime;
        this.totalCalories = totalCalories;
        this.totalProtein = totalProtein;
        this.totalFat = totalFat;
        this.totalCarbs = totalCarbs;
    }

    // Getters
    public Timestamp getMealTime() {
        return mealTime;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    // toString() メソッドを追加（デバッグ用）
    @Override
    public String toString() {
        return "MealSummary{" +
               "mealTime=" + mealTime +
               ", totalCalories=" + totalCalories +
               ", totalProtein=" + totalProtein +
               ", totalFat=" + totalFat +
               ", totalCarbs=" + totalCarbs +
               '}';
    }
}

