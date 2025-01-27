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
import utils.PasswordUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 定数を定義
    private static final String REGISTER_PAGE = "/WEB-INF/view/register.jsp";
    private static final String DASHBOARD_PAGE = "/WEB-INF/view/dashboard.jsp";
    private static final String LOGIN_PAGE = "/login";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 既にログインしている場合はダッシュボードにリダイレクト
        if (session.getAttribute("username") != null) {
            response.sendRedirect(DASHBOARD_PAGE);
            return;
        }

        // エラーメッセージがあればリクエストに設定
        String errorMessage = (String) session.getAttribute("error");
        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            session.removeAttribute("error");
        }

        // アカウント登録ページを表示
        request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // ユーザー入力を取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");

        // 入力の検証
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || email == null || email.isEmpty()) {
            session.setAttribute("error", "すべての項目を入力してください。");
            response.sendRedirect("/register");
            return;
        }

        if (!password.equals(confirmPassword)) {
            session.setAttribute("error", "パスワードが一致しません。");
            response.sendRedirect("/register");
            return;
        }

        if (!isValidEmail(email)) {
            session.setAttribute("error", "有効なメールアドレスを入力してください。");
            response.sendRedirect("/register");
            return;
        }

        UserDao userDao = DaoFactory.getUserDao();

        try {
            // ユーザー名またはメールアドレスが既に登録されているか確認
            if (userDao.checkIfUserExists(username)) {
                session.setAttribute("error", "ユーザー名が既に存在します。");
                response.sendRedirect("/register");
                return;
            }

            if (userDao.checkIfEmailExists(email)) {
                session.setAttribute("error", "メールアドレスが既に登録されています。");
                response.sendRedirect("/register");
                return;
            }

            // パスワードをハッシュ化してユーザーを作成
            String hashedPassword = PasswordUtils.hashPassword(password);
            boolean userCreated = userDao.createUser(username, hashedPassword, email);

            if (userCreated) {
                session.setAttribute("success", "登録が完了しました。ログインしてください。");
                response.sendRedirect(LOGIN_PAGE);
            } else {
                session.setAttribute("error", "登録に失敗しました。もう一度お試しください。");
                response.sendRedirect("/register");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "システムエラーが発生しました。");
            response.sendRedirect("/register");
        }
    }

    // メールアドレスの形式を検証するメソッド
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}

