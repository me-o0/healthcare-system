package dao;

import java.util.List;

import model.Meal;
import model.MealFood;

public interface MealDAO {
    boolean save(Meal meal);  // 食事の保存メソッド
    boolean saveMealFoods(List<MealFood> mealFoods, int mealId);  // 食品の保存メソッド
    List<Meal> getMealsByUserId(int userId);  // ユーザーIDによる食事履歴取得メソッド
}


