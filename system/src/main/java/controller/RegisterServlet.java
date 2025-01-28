package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // UserServiceのインスタンスを生成
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new UserService();  // UserServiceを初期化
    }

    // GETリクエストで登録ページを表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
    }

    // POSTリクエストでユーザー登録処理を実行
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // UserServiceを使用してユーザー登録
        boolean isRegistered = userService.register(username, password, email);

        if (isRegistered) {
            // 登録成功時、ログインページにリダイレクト
            response.sendRedirect("login");
        } else {
            // 登録失敗時、エラーメッセージを表示
            request.setAttribute("errorMessage", "登録に失敗しました。ユーザー名が既に存在するか、無効な情報が含まれています。");
            request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
        }
    }
}



