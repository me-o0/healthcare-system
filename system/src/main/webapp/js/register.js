// アカウント登録ボタンを押したときの処理
function register() {
  // ユーザーID、パスワード、確認用パスワードを取得
  const userId = document.getElementById("user-id").value;
  const userPass = document.getElementById("user-pass").value;
  const confirmPass = document.getElementById("confirm-pass").value;

  // パスワードが一致しているか確認
  if (userPass !== confirmPass) {
    alert("パスワードが一致しません");
    return;
  }

  // 仮のアカウント登録処理
  if (userId && userPass) {
    alert("アカウント登録成功");
    // サーバーとの通信処理を追加する
  } else {
    alert("すべての項目を入力してください");
  }
}
