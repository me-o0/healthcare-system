package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Food;
import utils.DatabaseUtils;

public class FoodDAOImpl implements FoodDAO {

    @Override
    public List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<>();
        String sql = "SELECT food_id, name, calories, protein, fat, carbs, category_id, created_at FROM foods";

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("food_id"));
                food.setName(rs.getString("name"));
                food.setCalories(rs.getInt("calories"));
                food.setProtein(rs.getInt("protein"));
                food.setFat(rs.getInt("fat"));
                food.setCarbs(rs.getInt("carbs"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setCreatedAt(rs.getTimestamp("created_at"));

                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foods;
    }

    @Override
    public Food getFoodById(int id) {
        String sql = "SELECT food_id, name, calories, protein, fat, carbs, category_id, created_at FROM foods WHERE food_id = ?";
        Food food = null;

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                food = new Food();
                food.setId(rs.getInt("food_id"));
                food.setName(rs.getString("name"));
                food.setCalories(rs.getInt("calories"));
                food.setProtein(rs.getInt("protein"));
                food.setFat(rs.getInt("fat"));
                food.setCarbs(rs.getInt("carbs"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setCreatedAt(rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return food;
    }
}


