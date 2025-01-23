package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import utils.EmailUtils;

public class PasswordResetServlet extends HttpServlet {
    // パスワードリセット処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserDao userDao = new UserDao();

        // メールアドレスが存在するかチェック
        if (userDao.checkIfEmailExists(email)) {
            // リセットトークン生成とメール送信
            String resetToken = userDao.generateResetToken(email); // emailを渡してリセットトークンを生成
            if (resetToken != null) {
                try {
                    // メール送信処理
                    EmailUtils.sendPasswordResetEmail(email, resetToken);
                    response.sendRedirect("reset_success.jsp"); // 成功した場合、成功画面にリダイレクト
                } catch (Exception e) {
                    // メール送信失敗時の処理
                    e.printStackTrace();
                    response.sendRedirect("reset.jsp?error=email_send_failed"); // エラーがあった場合にエラーメッセージを表示
                }
            } else {
                response.sendRedirect("reset.jsp?error=token_generation_failed"); // トークン生成失敗時
            }
        } else {
            response.sendRedirect("reset.jsp?error=email_not_found"); // メールアドレスが見つからない場合
        }
    }
}







