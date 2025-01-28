<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ログイン - ダッシュボード</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/bootstrap-icons/bootstrap-icons.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages/auth.css" />
  </head>

  <body>
    <div id="auth">
      <div class="row h-100">
        <div class="col-lg-6 col-12">
          <div id="auth-left">
            <div class="auth-logo">
              <a href="index.jsp"><img class="auth-logo" src="${pageContext.request.contextPath}/images/logo/logo.png" alt="ロゴ" /></a>
            </div>
            <h1 class="auth-title">ログイン</h1>
            <p class="auth-subtitle mb-5">登録した情報を入力。</p>

            <form action="${pageContext.request.contextPath}/login" method="post">
              <div class="form-group position-relative has-icon-left mb-4">
                <input type="text" class="form-control form-control-xl" placeholder="ユーザー名" name="username" required />
                <div class="form-control-icon">
                  <i class="bi bi-person"></i>
                </div>
              </div>
              <div class="form-group position-relative has-icon-left mb-4">
                <input type="password" class="form-control form-control-xl" placeholder="パスワード" name="password" required />
                <div class="form-control-icon">
                  <i class="bi bi-shield-lock"></i>
                </div>
              </div>
              <div class="form-check form-check-lg d-flex align-items-end">
                <input class="form-check-input me-2" type="checkbox" value="" id="flexCheckDefault" />
                <label class="form-check-label text-gray-600" for="flexCheckDefault"> ログイン状態を保持する </label>
              </div>
              <button class="btn btn-primary btn-block btn-lg shadow-lg mt-5" type="submit">ログイン</button>
            </form>

<!-- エラーメッセージ表示 -->
<% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger">
        <%= request.getAttribute("errorMessage") %>
    </div>
<% } %>

            <div class="text-center mt-5 text-lg fs-4">
              <p class="text-gray-600">アカウントをお持ちでないですか？ <a href="${pageContext.request.contextPath}/register" class="font-bold">登録する</a></p>
              <p><a class="font-bold" href="auth-forgot-password.jsp">パスワードを忘れた場合</a></p>
            </div>
          </div>
        </div>
        <div class="col-lg-6 d-none d-lg-block">
          <div id="auth-right"></div>
        </div>
      </div>
    </div>
  </body>
</html>
