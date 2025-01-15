// パスワード表示/非表示の切り替え
function togglePasswordVisibility() {
  const passwordField = document.getElementById("user-pass");

  // 表示状態を切り替え
  if (passwordField.type === "password") {
    passwordField.type = "text"; // 表示
  } else {
    passwordField.type = "password"; // 非表示
  }
}

// ログイン処理
function login() {
  const userId = document.getElementById("user-id").value;
  const userPass = document.getElementById("user-pass").value;

  // 仮のログイン認証
  if (userId === "admin" && userPass === "password") {
    alert("ログイン成功");
    // サーバーとの通信処理を追加
  } else {
    alert("ユーザーIDまたはパスワードが間違っています");
  }
}
