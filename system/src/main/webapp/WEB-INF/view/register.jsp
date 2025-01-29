<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <!-- メタデータ、文字コード、ビューポートの設定 -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>アカウント登録 - 管理者ダッシュボード</title>
    <!-- フォントとスタイルシートの読み込み -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/bootstrap-icons/bootstrap-icons.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages/auth.css" />
  </head>

  <body>
    <!-- 認証セクション -->
    <div id="auth">
      <div class="row h-100">
        <div class="col-lg-6 col-12">
          <div id="auth-left">
            <!-- ロゴ -->
            <div class="auth-logo">
              <a href="index.jsp"><img class="auth-logo" src="${pageContext.request.contextPath}/images/logo/logo.png" alt="ロゴ" /></a>
            </div>
            <h1 class="auth-title">アカウント<br />登録</h1>
            <p class="auth-subtitle mb-5">登録情報を入力。</p>

<!-- エラーメッセージ表示 -->
<% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger">
        <%= request.getAttribute("errorMessage") %>
    </div>
<% } %>
<!-- 登録フォーム -->
<form action="${pageContext.request.contextPath}/register" method="POST" onsubmit="return validatePasswords()">
  <!-- メールアドレス入力 -->
  <div class="form-group position-relative has-icon-left mb-4">
    <input type="email" class="form-control form-control-xl" placeholder="メールアドレス" name="email" required />
    <div class="form-control-icon">
      <i class="bi bi-envelope"></i>
    </div>
  </div>
  <!-- ユーザー名入力 -->
  <div class="form-group position-relative has-icon-left mb-4">
    <input type="text" class="form-control form-control-xl" placeholder="ユーザー名" name="username" required />
    <div class="form-control-icon">
      <i class="bi bi-person"></i>
    </div>
  </div>
  <!-- パスワード入力 -->
  <div class="form-group position-relative has-icon-left mb-4">
    <input type="password" class="form-control form-control-xl" placeholder="パスワード" name="password" required />
    <div class="form-control-icon">
      <i class="bi bi-shield-lock"></i>
    </div>
  </div>
  <!-- 確認用パスワード入力 -->
  <div class="form-group position-relative has-icon-left mb-4">
    <input type="password" class="form-control form-control-xl" placeholder="確認用パスワード" name="confirmPassword" required />
    <div class="form-control-icon">
      <i class="bi bi-shield-lock"></i>
    </div>
  </div>
  <!-- 登録ボタン -->
  <button class="btn btn-primary btn-block btn-lg shadow-lg mt-5" type="submit">ログイン情報を登録</button>
</form>

<script>
  function validatePasswords() {
    const password = document.querySelector('input[name="password"]').value;
    const confirmPassword = document.querySelector('input[name="confirmPassword"]').value;
    
    if (password !== confirmPassword) {
      alert("パスワードと確認用パスワードが一致しません。");
      return false; // フォーム送信をキャンセル
    }
    return true; // 一致している場合はフォーム送信を許可
  }
</script>

            <!-- 既存のアカウントを持っている場合のリンク -->
            <div class="text-center mt-5 text-lg fs-4">
              <p class="text-gray-600">既にアカウントをお持ちですか？<br /><a href="${pageContext.request.contextPath}/login" class="font-bold">ログイン</a>。</p>
            </div>
          </div>
        </div>
        <!-- 右側の空きスペース -->
        <div class="col-lg-6 d-none d-lg-block">
          <div id="auth-right"></div>
        </div>
      </div>
    </div>
  </body>
</html>
