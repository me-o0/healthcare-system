<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ログイン - Mazer 管理ダッシュボード</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/bootstrap-icons/bootstrap-icons.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/auth.css" />
  </head>

  <body>
    <div id="auth">
      <div class="row h-100">
        <div class="col-lg-5 col-12">
          <div id="auth-left">
            <div class="auth-logo">
              <a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/assets/images/logo/logo.png" alt="ロゴ" /></a>
            </div>
            <h1 class="auth-title">パスワードを<br />忘れた場合</h1>
            <p class="auth-subtitle mb-5">パスワードをリセットするためのリンクを送信。</p>

            <!-- フォームの送信先をサーブレットに設定 -->
            <form action="${pageContext.request.contextPath}/password-reset" method="post">
              <div class="form-group position-relative has-icon-left mb-4">
                <input type="email" class="form-control form-control-xl" placeholder="メールアドレス" name="email" required />
                <div class="form-control-icon">
                  <i class="bi bi-envelope"></i>
                </div>
              </div>
              <button class="btn btn-primary btn-block btn-lg shadow-lg mt-5">送信</button>
            </form>

            <!-- エラーメッセージの表示 -->
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger mt-3">
                <c:choose>
                  <c:when test="${param.error == 'email_send_failed'}">メールの送信に失敗しました。再度お試しください。</c:when>
                  <c:when test="${param.error == 'token_generation_failed'}">リセットトークンの生成に失敗しました。</c:when>
                  <c:when test="${param.error == 'email_not_found'}">そのメールアドレスは登録されていません。</c:when>
                  <c:otherwise>エラーが発生しました。</c:otherwise>
                </c:choose>
              </div>
            </c:if>

            <!-- 成功メッセージの表示 -->
            <c:if test="${not empty param.success}">
              <div class="alert alert-success mt-3">
                パスワードリセットリンクが送信されました。メールをご確認ください。
              </div>
            </c:if>

            <div class="text-center mt-5 text-lg fs-4">
              <p class="text-gray-600">アカウントを覚えていますか？ <a href="${pageContext.request.contextPath}/auth-login.html" class="font-bold">ログイン</a>してください。</p>
            </div>
          </div>
        </div>
        <div class="col-lg-7 d-none d-lg-block">
          <div id="auth-right"></div>
        </div>
      </div>
    </div>
  </body>
</html>
