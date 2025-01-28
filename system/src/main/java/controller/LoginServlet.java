package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // UserServiceのインスタンスを生成
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new UserService();  // UserServiceを初期化
    }

    // GETリクエストでログインページを表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    // POSTリクエストでログイン処理を実行
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // UserServiceを使用してログイン認証
        boolean isValid = userService.login(username, password);

        if (isValid) {
            // 認証成功時、ダッシュボードにリダイレクト
            response.sendRedirect("dashboard");
        } else {
            // 認証失敗時、エラーメッセージを表示
            request.setAttribute("errorMessage", "ユーザー名またはパスワードが間違っています。");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
    }
}








