package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // データベースからハッシュ化されたパスワードを取得
        String hashedPassword = userDao.getPasswordHashByUsername(username);

        if (hashedPassword != null && BCrypt.checkpw(password, hashedPassword)) {
            // 認証成功
            response.sendRedirect("top.jsp");
        } else {
            // 認証失敗
            request.setAttribute("error", "ユーザー名またはパスワードが間違っています");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

