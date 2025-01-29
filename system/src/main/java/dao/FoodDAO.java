package dao;

import java.util.List;

import model.Food;

public interface FoodDAO {
    List<Food> getAllFoods();  // すべての食品を取得
    Food getFoodById(int id);  // 食品IDで取得
}

