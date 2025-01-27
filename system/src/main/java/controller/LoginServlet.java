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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // URLやエラーメッセージの定数化
    private static final String LOGIN_PAGE = "/WEB-INF/view/login.jsp";
    private static final String DASHBOARD_PAGE = "/WEB-INF/view/dashboard.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 既にログインしている場合はダッシュボードにリダイレクト
        if (session.getAttribute("username") != null) {
            response.sendRedirect(DASHBOARD_PAGE);
            return;
        }

        // セッションにエラーメッセージがあればリクエスト属性に設定
        String errorMessage = (String) session.getAttribute("error");
        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            session.removeAttribute("error");
        }

        // ログインページを表示
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        // 入力チェック
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            session.setAttribute("error", "ユーザー名とパスワードを入力してください。");
            response.sendRedirect("/login");
            return;
        }

        UserDao userDao = DaoFactory.getUserDao();

        try {
            // ユーザーが存在するか確認
            if (userDao.checkIfUserExists(username)) {
                String hashedPassword = userDao.getUserPassword(username);

                // パスワードが一致するか確認
                if (PasswordUtils.verifyPassword(password, hashedPassword)) {
                    // アカウントロックを確認
                    if (userDao.isAccountLocked(username)) {
                        session.setAttribute("error", "アカウントはロックされています。管理者にお問い合わせください。");
                        response.sendRedirect("/login");
                        return;
                    }

                    // ログイン成功：失敗回数リセット、セッションにユーザー情報を保存
                    userDao.resetFailedAttempts(username);
                    session.setAttribute("username", username);
                    response.sendRedirect(DASHBOARD_PAGE);
                } else {
                    // パスワード不一致：失敗回数をインクリメント
                    userDao.incrementFailedAttempts(username);
                    session.setAttribute("error", "ユーザー名またはパスワードが正しくありません。");
                    response.sendRedirect("/login");
                }
            } else {
                // ユーザーが存在しない場合
                session.setAttribute("error", "ユーザーが見つかりません。");
                response.sendRedirect("/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "システムエラーが発生しました。");
            response.sendRedirect("/login");
        }
    }
}





