package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import utils.PasswordUtils;

public class RegisterServlet extends HttpServlet {
    // ユーザー登録処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();

        // ユーザー名やメールが既に存在するか確認
        if (userDao.checkIfUserExists(username) || userDao.checkIfEmailExists(email)) {
            response.sendRedirect("register.jsp?error=user_exists"); // すでにユーザーが存在する場合
        } else {
            // パスワードをハッシュ化
            String hashedPassword = PasswordUtils.hashPassword(password);
            
            // ユーザー作成処理
            boolean userCreated = userDao.createUser(username, hashedPassword, email);
            if (userCreated) {
                // ユーザー作成成功
                response.sendRedirect("login.jsp"); // ログインページにリダイレクト
            } else {
                // ユーザー作成失敗
                response.sendRedirect("register.jsp?error=registration_failed");
            }
        }
    }
}






