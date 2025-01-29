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
import model.MealSummary;
import utils.DatabaseUtils;

public class MealDAOImpl implements MealDAO {

    @Override
    public boolean save(Meal meal) {
        String mealSql = "INSERT INTO meals (user_id, meal_type, meal_date, meal_time, meal_source, notes) VALUES (?, ?, ?, NOW(), ?, ?)";

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(mealSql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, meal.getUserId());
            stmt.setString(2, meal.getMealType());
            stmt.setTimestamp(3, meal.getMealDate());
            stmt.setString(4, meal.getMealSource());
            stmt.setString(5, meal.getNotes());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int mealId = generatedKeys.getInt(1);
                    return saveMealFoods(meal.getMealFoods(), mealId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveMealFoods(List<MealFood> mealFoods, int mealId) {
        String sql = "INSERT INTO meal_foods (meal_id, food_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (MealFood mealFood : mealFoods) {
                stmt.setInt(1, mealId);
                stmt.setInt(2, mealFood.getFoodId());
                stmt.setDouble(3, mealFood.getQuantity());
                stmt.addBatch();
            }

            int[] rowsAffected = stmt.executeBatch();
            return rowsAffected.length > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Meal> getMealsByUserId(int userId) {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT id, meal_type, meal_date, meal_time, meal_source, notes FROM meals WHERE user_id = ? ORDER BY meal_date DESC";

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Meal meal = new Meal();
                meal.setMealId(rs.getInt("id"));
                meal.setMealType(rs.getString("meal_type"));
                meal.setMealDate(rs.getTimestamp("meal_date"));
                meal.setMealTime(rs.getTimestamp("meal_time"));
                meal.setMealSource(rs.getString("meal_source"));
                meal.setNotes(rs.getString("notes"));
                meals.add(meal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meals;
    }

    public List<MealSummary> getDailyNutritionSummaryByUserId(int userId) {
        List<MealSummary> summaryList = new ArrayList<>();

        String sql = """
            SELECT 
                meal.meal_time AS meal_time,  -- meal_timeをそのまま使用
                SUM(food.calories * meal_food.quantity) AS total_calories,
                SUM(food.protein * meal_food.quantity) AS total_protein,
                SUM(food.fat * meal_food.quantity) AS total_fat,
                SUM(food.carbs * meal_food.quantity) AS total_carbs
            FROM meal
            JOIN meal_food ON meal.meal_id = meal_food.meal_id
            JOIN food ON meal_food.food_id = food.food_id
            WHERE meal.user_id = ?
            GROUP BY meal_time
            ORDER BY meal_time DESC;
        """;

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // meal_timeをTimestamp型で取得
                    MealSummary summary = new MealSummary(
                        rs.getTimestamp("meal_time"),  // meal_timeをTimestamp型で取得
                        rs.getInt("total_calories"),
                        rs.getInt("total_protein"),
                        rs.getInt("total_fat"),
                        rs.getInt("total_carbs")
                    );
                    summaryList.add(summary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return summaryList;
    }
}