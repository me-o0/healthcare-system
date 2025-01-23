package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import utils.PasswordUtils;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        UserDao userDao = new UserDao();

        // ユーザーが存在するかチェック
        if (userDao.checkIfUserExists(username)) {
            String hashedPassword = userDao.getUserPassword(username);
            
            // パスワードが正しいか検証
            if (PasswordUtils.verifyPassword(password, hashedPassword)) {
                // アカウントロックの確認
                if (userDao.isAccountLocked(username)) {
                    request.setAttribute("error", "account_locked");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    return;
                }
                
                // ログイン成功、セッションにユーザー情報を保存
                session.setAttribute("username", username);
                response.sendRedirect("dashboard.jsp"); // ダッシュボードにリダイレクト
            } else {
                // パスワードが一致しない場合
                userDao.incrementFailedAttempts(username);
                request.setAttribute("error", "invalid_credentials");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "user_not_found");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}







