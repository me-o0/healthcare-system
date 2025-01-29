package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodDAO;
import dao.FoodDAOFactory;
import dao.MealDAO;
import dao.MealDAOFactory;
import model.Food;
import model.Meal;
import model.MealFood;
import model.MealSummary;
import model.User;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションからユーザー情報を取得
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // ユーザー情報がない場合はログインページにリダイレクト
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // FoodDAOのインスタンスを取得し、食品データを取得
        FoodDAO foodDAO = FoodDAOFactory.getFoodDAO();
        List<Food> foodList = foodDAO.getAllFoods();
        request.setAttribute("foodList", foodList);

        // MealDAOのインスタンスを取得し、食事履歴を取得
        MealDAO mealDAO = MealDAOFactory.getMealDAO();
        List<Meal> meals = mealDAO.getMealsByUserId(user.getId());
        request.setAttribute("meals", meals);

        // 日ごとの栄養素集計を取得
        List<MealSummary> mealSummaries = mealDAO.getDailyNutritionSummaryByUserId(user.getId());
        request.setAttribute("mealSummaries", mealSummaries);

        // ダッシュボードページを表示
        request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションからユーザー情報を取得
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // ユーザー情報がない場合はログインページにリダイレクト
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // フォームデータを取得
        String mealType = request.getParameter("meal_type");
        String mealSource = request.getParameter("meal_source");
        String notes = request.getParameter("notes");
        String mealDateStr = request.getParameter("meal_date"); // meal_dateを取得

        // mealDateをTimestamp型に変換
        Timestamp mealDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            mealDate = new Timestamp(sdf.parse(mealDateStr).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 食品情報を取得（複数の食品が登録されることを想定）
        String[] foodIds = request.getParameterValues("food_id");
        String[] quantities = request.getParameterValues("quantity");

        // Mealオブジェクトの作成
        Meal meal = new Meal();
        meal.setUserId(user.getId());
        meal.setMealType(mealType);
        meal.setMealSource(mealSource);
        meal.setNotes(notes);
        meal.setMealTime(mealDate);  // mealTimeにmealDateを設定

        // 食品情報をMealFoodオブジェクトに設定
        List<MealFood> mealFoods = new ArrayList<>();
        for (int i = 0; i < foodIds.length; i++) {
            MealFood mealFood = new MealFood();
            mealFood.setFoodId(Integer.parseInt(foodIds[i]));
            mealFood.setQuantity(Double.parseDouble(quantities[i]));
            mealFoods.add(mealFood);
        }
        meal.setMealFoods(mealFoods);

        // MealDAOインスタンスの取得
        MealDAO mealDAO = MealDAOFactory.getMealDAO();

        // データベースに保存
        boolean isSuccess = mealDAO.save(meal);

        // 成功したらダッシュボードにリダイレクト
        if (isSuccess) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            // 失敗した場合、エラーメッセージを表示して再度ダッシュボードに戻る
            request.setAttribute("errorMessage", "食事登録に失敗しました。");
            request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp").forward(request, response);
        }
    }
}