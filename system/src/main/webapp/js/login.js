document.addEventListener("DOMContentLoaded", function() {
  const loginForm = document.querySelector('form[action="login"]');
  
  // ログインフォームの送信時にバリデーションを実施
  loginForm.addEventListener("submit", function(event) {
    const username = document.querySelector('input[name="username"]').value;
    const password = document.querySelector('input[name="password"]').value;

    // ユーザー名とパスワードの入力チェック
    if (username.trim() === "" || password.trim() === "") {
      event.preventDefault(); // フォーム送信をキャンセル
      alert("ユーザー名とパスワードを入力してください。");
    }
  });
});
