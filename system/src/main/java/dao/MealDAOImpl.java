package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Meal;
import model.MealFood;
import utils.DatabaseUtils;

public class MealDAOImpl implements MealDAO {

    @Override
    public boolean save(Meal meal) {
        // 食事情報を保存する処理
        String mealSql = "INSERT INTO meals (user_id, meal_type, meal_date, meal_time, meal_source, notes) VALUES (?, ?, ?, NOW(), ?, ?)";
        
        try (Connection conn = DatabaseUtils.getConnection()) {
            // 食事データを挿入
            try (PreparedStatement stmt = conn.prepareStatement(mealSql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, meal.getUserId());
                stmt.setString(2, meal.getMealType());
                stmt.setString(3, meal.getMealDate());  // meal_date を追加
                stmt.setString(4, meal.getMealSource());
                stmt.setString(5, meal.getNotes());

                int rowsAffected = stmt.executeUpdate();  // 挿入した行数を取得

                // 挿入が成功したかチェック
                if (rowsAffected > 0) {
                    // 挿入した食事のIDを取得
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int mealId = generatedKeys.getInt(1);
                        // 食品の保存処理を行う
                        return saveMealFoods(meal.getMealFoods(), mealId); // 食品情報の保存
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;  // 挿入失敗
    }

    @Override
    public boolean saveMealFoods(List<MealFood> mealFoods, int mealId) {
        // meal_foodsテーブルに食品データを挿入
        String sql = "INSERT INTO meal_foods (meal_id, food_id, quantity) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseUtils.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                for (MealFood mealFood : mealFoods) {
                    stmt.setInt(1, mealId);  // 食事ID
                    stmt.setInt(2, mealFood.getFoodId());  // 食品ID
                    stmt.setDouble(3, mealFood.getQuantity());  // 食品の量
                    stmt.addBatch();  // バッチに追加
                }

                // バッチ処理を実行
                int[] rowsAffected = stmt.executeBatch();

                // rowsAffected配列内で影響を受けた行数が1件以上あれば成功
                int totalRowsAffected = 0;
                for (int row : rowsAffected) {
                    totalRowsAffected += row;  // 合計影響行数を計算
                }

                return totalRowsAffected > 0;  // 1件以上の行が挿入された場合はtrue
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Meal> getMealsByUserId(int userId) {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT id, meal_type, meal_date, meal_time, meal_source, notes FROM meals WHERE user_id = ?";
        
        try (Connection conn = DatabaseUtils.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Meal meal = new Meal();
                    meal.setMealId(rs.getInt("id"));
                    meal.setMealType(rs.getString("meal_type"));
                    meal.setMealDate(rs.getString("meal_date"));  // meal_date を設定
                    meal.setMealTime(rs.getTimestamp("meal_time"));
                    meal.setMealSource(rs.getString("meal_source"));
                    meal.setNotes(rs.getString("notes"));

                    // この食事に関連する食品を取得する（必要に応じて実装）
                    // meal.setMealFoods(fetchMealFoodsForMeal(meal.getId()));  // 例: fetchMealFoodsForMeal() メソッドを実装して食品を取得

                    meals.add(meal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meals;
    }
}





