package model;

import java.sql.Timestamp;

public class Food {
    private int id;          // 食品ID
    private String name;     // 食品名
    private int calories;    // カロリー
    private int protein;     // たんぱく質
    private int fat;         // 脂質
    private int carbs;       // 炭水化物
    private int categoryId;  // 食品カテゴリID
    private Timestamp createdAt; // 作成日時

    // コンストラクタ
    public Food() {}

    public Food(int id, String name, int calories, int protein, int fat, int carbs, int categoryId, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
