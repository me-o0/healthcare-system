package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.UserDao;
import model.User;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DashboardServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // セッションからユーザー名を取得
        String username = (String) session.getAttribute("username");

        if (username == null) {
            // ログインしていない場合、ログインページにリダイレクト
            response.sendRedirect("login");
            return;
        }

        try {
            // DAOを利用してユーザー情報を取得
            UserDao userDao = DaoFactory.getUserDao();
            User user = userDao.getUserByUsername(username);

            if (user == null) {
                // ユーザー情報が見つからない場合、ログアウトしてログインページへ
                session.invalidate();
                response.sendRedirect("login");
                return;
            }

            // ユーザー情報をリクエストに設定
            request.setAttribute("user", user);

            // JSPにフォワードしてダッシュボードを表示
            request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // エラー時にエラーページまたはログインページへリダイレクト
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

