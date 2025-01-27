document.addEventListener("DOMContentLoaded", function() {
  const registerForm = document.querySelector('form[action="register"]');
  
  // 登録フォームの送信時にバリデーションを実施
  registerForm.addEventListener("submit", function(event) {
    const password = document.querySelector('input[name="password"]').value;
    const confirmPassword = document.querySelector('input[name="confirmPassword"]').value;

    // パスワードが一致しない場合
    if (password !== confirmPassword) {
      event.preventDefault(); // フォーム送信をキャンセル
      alert("パスワードが一致しません。");
    }

    // 必要項目の空欄チェック
    const email = document.querySelector('input[name="email"]').value;
    const username = document.querySelector('input[name="username"]').value;

    if (email.trim() === "" || username.trim() === "" || password.trim() === "") {
      event.preventDefault(); // フォーム送信をキャンセル
      alert("全てのフィールドを正しく入力してください。");
    }
  });
});
