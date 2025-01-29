package dao;

import java.util.List;

import model.Food;

public interface FoodDAO {
    List<Food> getAllFoods();
    Food getFoodById(int id);
}


