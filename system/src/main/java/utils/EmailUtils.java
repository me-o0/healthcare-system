package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;  // 追加
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

    // パスワードリセット用のメールを送信
    public static void sendPasswordResetEmail(String email, String resetToken) throws MessagingException {
        String subject = "Password Reset Request";
        String body = "Click the link below to reset your password:\n"
                    + "http://yourwebsite.com/reset_password?token=" + resetToken;

        // 設定ファイルや環境変数から情報を取得する
        String host = System.getenv("SMTP_HOST");
        String from = System.getenv("SMTP_FROM_EMAIL");
        String to = email;
        String smtpUser = System.getenv("SMTP_USER");
        String smtpPassword = System.getenv("SMTP_PASSWORD");

        if (host == null || from == null || smtpUser == null || smtpPassword == null) {
            throw new MessagingException("SMTP configuration is missing.");
        }

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUser, smtpPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
            throw mex; // エラー発生時に呼び出し元に通知
        }
    }
}




