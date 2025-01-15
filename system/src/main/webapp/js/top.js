// ドキュメント全体でクリックイベントをリスン
document.addEventListener("click", function (event) {
  const sideMenu = document.getElementById("sideMenu"); // サイドメニューのDOM要素
  const menuIcon = document.querySelector(".menu-icon"); // メニューアイコンのDOM要素

  // サイドメニューまたはメニューアイコンがクリックされている場合は無視
  const isMenuClicked = sideMenu.contains(event.target) || menuIcon.contains(event.target);

  // サイドメニューが開いている状態で、メニュー外をクリックした場合に閉じる
  if (!isMenuClicked && sideMenu.classList.contains("open")) {
    sideMenu.classList.remove("open"); // メニューを閉じる
    sideMenu.classList.add("closed"); // メニューを閉じた状態に設定
  }
});

// ハンバーガーメニューのクリックでサイドメニューを開閉
function toggleMenu() {
  const sideMenu = document.getElementById("sideMenu");

  // メニューが閉じている場合、開く
  if (sideMenu.classList.contains("closed")) {
    sideMenu.classList.remove("closed");
    sideMenu.classList.add("open");
  } else {
    // メニューが開いている場合、閉じる
    sideMenu.classList.remove("open");
    sideMenu.classList.add("closed");
  }
}
