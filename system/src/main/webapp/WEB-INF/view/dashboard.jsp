<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ダッシュボード - Mazer 管理ダッシュボード</title>

    <!-- フォントやスタイルシートのリンク -->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet" />
    <!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/iconly/bold.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/perfect-scrollbar/perfect-scrollbar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/bootstrap-icons/bootstrap-icons.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}//images/favicon.svg" type="image/x-icon" />
    <script>
  function toggleFoodInput(mealType) {
    const foodInputId = `food_input_${mealType}`;
    const foodSelectId = `food_name_${mealType}`;
    const caloriesGroupId = `calories-group-${mealType}`;

    const foodInput = document.getElementById(foodInputId);
    const foodSelect = document.getElementById(foodSelectId);
    const caloriesGroup = document.getElementById(caloriesGroupId);

    if (foodSelect.value === "" && foodInput.value !== "") {
      caloriesGroup.style.display = "block";  // カロリー入力を表示
    } else if (foodInput.value === "") {
      caloriesGroup.style.display = "none";  // カロリー入力を非表示
    } else {
      caloriesGroup.style.display = "block";  // カロリー入力を表示
    }
  }
</script>
  </head>
  
  <body>
    <div id="app">
      <div id="sidebar" class="active">
        <div class="sidebar-wrapper active">
          <div class="sidebar-header">
            <!-- サイドバーのヘッダー部分 -->
            <div class="d-flex justify-content-between">
              <div class="logo">
                <a href="index.html"><img class="sidebar-logo" src="${pageContext.request.contextPath}/images/logo/logo.png" alt="ロゴ" srcset="" /></a>
              </div>
              <div class="toggler">
                <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
              </div>
            </div>
          </div>
          <div class="sidebar-menu">
            <!-- サイドバーのメニュー -->
            <ul class="menu">
              <li class="sidebar-title">メニュー</li>
              <!-- メニューのタイトル -->

              <li class="sidebar-item active">
                <!-- ダッシュボードのリンク -->
                <a href="index.html" class="sidebar-link">
                  <i class="bi bi-grid-fill"></i>
                  <span>ダッシュボード</span>
                </a>
              </li>

              <li class="sidebar-item has-sub">
                <!-- コンポーネントセクション -->
                <a href="#" class="sidebar-link">
                  <i class="bi bi-stack"></i>
                  <span>健康記録</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">TOP</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">やることリスト</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">食事データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">運動データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">睡眠データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">服薬データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">断食データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">水分データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">飲酒データ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">関連設定</a>
                  </li>
                </ul>
              </li>

              <li class="sidebar-item has-sub">
                <a href="#" class="sidebar-link">
                  <i class="bi bi-bar-chart-fill"></i>
                  <span>記録管理</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">目標設定</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">進歩レポート</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">アドバイス</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">データ分析</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">提案プラン</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">バッジ一覧</a>
                  </li>
                  <li class="sidebar-item">
                    <a href="ui-file-uploader.html" class="sidebar-link">
                      <i class="bi bi-cloud-arrow-up-fill"></i>
                      <span>データ出力</span>
                    </a>
                  </li>
                  <li class="submenu-item">
                    <a href="l">関連設定</a>
                  </li>
                </ul>
              </li>

              <li class="sidebar-item has-sub">
                <!-- レイアウトセクション -->
                <a href="#" class="sidebar-link">
                  <i class="bi bi-chat-dots-fill"></i>
                  <span>コミュニティ</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">マイページ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">ユーザー検索</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">日記検索</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">コミュニティ検索</a>
                  </li>
                </ul>
              </li>
              <li class="sidebar-item has-sub">
                <a href="#" class="sidebar-link">
                  <i class="bi bi-egg-fill"></i>
                  <span>ゲーミング</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">クエスト一覧</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">ペット育成</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">ランキング</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">ポイント交換</a>
                  </li>
                </ul>
              </li>
              <li class="sidebar-title">運営</li>
              <!-- フォームとテーブル -->

              <li class="sidebar-item has-sub">
                <!-- フォーム要素 -->
                <a href="#" class="sidebar-link">
                  <i class="bi bi-grid-1x2-fill"></i>
                  <span>コラム</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">お知らせ</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">記事</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">FAQ</a>
                  </li>
                </ul>
              </li>

              <li class="sidebar-item has-sub">
                <!-- フォーム要素 -->
                <a href="#" class="sidebar-link">
                  <i class="bi bi-envelope-fill"></i>
                  <span>問い合わせ</span>
                </a>
                <ul class="submenu">
                  <li class="submenu-item">
                    <a href="">お困りの際はこちら</a>
                  </li>
                  <li class="submenu-item">
                    <a href="">SNS</a>
                  </li>
                </ul>
              </li>
              <li class="sidebar-title">その他</li>

              <li class="sidebar-item active has-sub">
                <a href="#" class="sidebar-link">
                  <i class="bi bi-hexagon-fill"></i>
                  <span>設定</span>
                </a>
              </li>

              <li class="sidebar-item">
                <a href="" class="sidebar-link">
                  <i class="bi bi-person-badge-fill"></i>
                  <span>ログアウト</span>
                </a>
              </li>
            </ul>
          </div>
          <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
        </div>
      </div>
      <div id="main">
        <header class="mb-3">
          <a href="#" class="burger-btn d-block d-xl-none">
            <i class="bi bi-justify fs-3"></i>
          </a>
        </header>

       <div id="app">
      <div class="page-heading">
        <h3>食事登録</h3>
      </div>

      <div class="page-content">
        <section class="row">
          <div class="col-12 col-lg-9">
            <div class="row">
              <!-- 朝食 -->
              <div class="col-6 col-lg-3 col-md-6">
                <div class="card">
                  <button class="card-btn" data-toggle="collapse" data-target="#breakfastForm" aria-expanded="false" aria-controls="breakfastForm">
                    <div class="card-body px-3 py-4-5">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="stats-icon purple">
                            <i class="bi-brightness-alt-high-fill"></i>
                          </div>
                        </div>
                        <div class="col-md-8">
                          <h6 class="text-muted font-semibold">朝食</h6>
                          <h6 class="font-extrabold mb-0">総カロリー</h6>
                        </div>
                      </div>
                    </div>
                  </button>
                </div>
              </div>

              <!-- 昼食 -->
              <div class="col-6 col-lg-3 col-md-6">
                <div class="card">
                  <button class="card-btn" data-toggle="collapse" data-target="#lunchForm" aria-expanded="false" aria-controls="lunchForm">
                    <div class="card-body px-3 py-4-5">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="stats-icon blue">
                            <i class="bi-brightness-high-fill"></i>
                          </div>
                        </div>
                        <div class="col-md-8">
                          <h6 class="text-muted font-semibold">昼食</h6>
                          <h6 class="font-extrabold mb-0">総カロリー</h6>
                        </div>
                      </div>
                    </div>
                  </button>
                </div>
              </div>

              <!-- 夕食 -->
              <div class="col-6 col-lg-3 col-md-6">
                <div class="card">
                  <button class="card-btn" data-toggle="collapse" data-target="#dinnerForm" aria-expanded="false" aria-controls="dinnerForm">
                    <div class="card-body px-3 py-4-5">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="stats-icon green">
                            <i class="bi-moon"></i>
                          </div>
                        </div>
                        <div class="col-md-8">
                          <h6 class="text-muted font-semibold">夕食</h6>
                          <h6 class="font-extrabold mb-0">総カロリー</h6>
                        </div>
                      </div>
                    </div>
                  </button>
                </div>
              </div>

              <!-- 間食 -->
              <div class="col-6 col-lg-3 col-md-6">
                <div class="card">
                  <button class="card-btn" data-toggle="collapse" data-target="#snackForm" aria-expanded="false" aria-controls="snackForm">
                    <div class="card-body px-3 py-4-5">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="stats-icon red">
                            <i class="bi-person-plus-fill"></i>
                          </div>
                        </div>
                        <div class="col-md-8">
                          <h6 class="text-muted font-semibold">間食</h6>
                          <h6 class="font-extrabold mb-0">総カロリー</h6>
                        </div>
                      </div>
                    </div>
                  </button>
                </div>
              </div>
            </div>
          </div>
        </section>

        <!-- 食事登録フォーム（朝食） -->
<div class="collapse card" id="breakfastForm">
  <form action="meal-register" method="post">
    <!-- 日付フィールドの追加 -->
    <div class="form-group">
      <label for="meal_date">日付</label>
      <input type="date" id="meal_date" name="meal_date" class="form-control meal" required />
    </div>

    <div class="form-group">
      <label for="food_name">食品名</label>
      <select id="food_name" name="food_id" class="form-control meal" required>
        <option value="">食品を選択</option>
        <c:forEach var="food" items="${foodList}">
          <option value="${food.id}">${food.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="quantity">数量（個）</label>
      <input type="number" id="quantity" name="quantity" class="form-control meal" required />
    </div>
   

    <button type="submit" class="btn btn-primary">登録する</button>
    <input type="hidden" name="meal_type" value="朝食" />
  </form>
</div>

<!-- 食事登録フォーム（昼食） -->
<div class="collapse card" id="lunchForm">
  <form action="meal-register" method="post">
    <!-- 日付フィールドの追加 -->
    <div class="form-group">
      <label for="meal_date">日付</label>
      <input type="date" id="meal_date" name="meal_date" class="form-control meal" required />
    </div>

    <div class="form-group">
      <label for="food_name">食品名</label>
      <select id="food_name" name="food_id" class="form-control meal" required>
        <option value="">食品を選択</option>
        <c:forEach var="food" items="${foodList}">
          <option value="${food.id}">${food.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="quantity">数量（個）</label>
      <input type="number" id="quantity" name="quantity" class="form-control meal" required />
    </div>


    <button type="submit" class="btn btn-primary">登録する</button>
    <input type="hidden" name="meal_type" value="昼食" />
  </form>
</div>

<!-- 食事登録フォーム（夕食） -->
<div class="collapse card" id="dinnerForm">
  <form action="meal-register" method="post">
    <!-- 日付フィールドの追加 -->
    <div class="form-group">
      <label for="meal_date">日付</label>
      <input type="date" id="meal_date" name="meal_date" class="form-control meal" required />
    </div>

    <div class="form-group">
      <label for="food_name">食品名</label>
      <select id="food_name" name="food_id" class="form-control meal" required>
        <option value="">食品を選択</option>
        <c:forEach var="food" items="${foodList}">
          <option value="${food.id}">${food.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="quantity">数量（個）</label>
      <input type="number" id="quantity" name="quantity" class="form-control meal" required />
    </div>


    <button type="submit" class="btn btn-primary">登録する</button>
    <input type="hidden" name="meal_type" value="夕食" />
  </form>
</div>

<!-- 食事登録フォーム（間食） -->
<div class="collapse card" id="snackForm">
  <form action="meal-register" method="post">
    <!-- 日付フィールドの追加 -->
    <div class="form-group">
      <label for="meal_date">日付</label>
      <input type="date" id="meal_date" name="meal_date" class="form-control meal" required />
    </div>

    <div class="form-group">
      <label for="food_name">食品名</label>
      <select id="food_name" name="food_id" class="form-control meal" required>
        <option value="">食品を選択</option>
        <c:forEach var="food" items="${foodList}">
          <option value="${food.id}">${food.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="quantity">数量（個）</label>
      <input type="number" id="quantity" name="quantity" class="form-control meal" required />
    </div>

    <button type="submit" class="btn btn-primary">登録する</button>
    <input type="hidden" name="meal_type" value="間食" />
  </form>
</div>


              <div class="row">
                <div class="col-12">
                  <div class="card">
                    <div class="card-header">
                      <h4>健康度</h4>
                    </div>
                    <div class="card-body">
                      <div id="chart-profile-visit"></div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-12 col-xl-4">
                  <div class="card">
                    <div class="card-header">
                      <h4>比較分析</h4>
                    </div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-6">
                          <div class="d-flex align-items-center">
                            <svg class="bi text-primary" width="32" height="32" fill="blue" style="width: 10px">
                              <use xlink:href="assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                            </svg>
                            <h5 class="mb-0 ms-3">摂取カロリー</h5>
                          </div>
                        </div>
                        <div class="col-6">
                          <h5 class="mb-0">862</h5>
                        </div>
                        <div class="col-12">
                          <div id="chart-europe"></div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-6">
                          <div class="d-flex align-items-center">
                            <svg class="bi text-success" width="32" height="32" fill="blue" style="width: 10px">
                              <use xlink:href="assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                            </svg>
                            <h5 class="mb-0 ms-3">消費カロリー</h5>
                          </div>
                        </div>
                        <div class="col-6">
                          <h5 class="mb-0">375</h5>
                        </div>
                        <div class="col-12">
                          <div id="chart-america"></div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-6">
                          <div class="d-flex align-items-center">
                            <svg class="bi text-danger" width="32" height="32" fill="blue" style="width: 10px">
                              <use xlink:href="assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                            </svg>
                            <h5 class="mb-0 ms-3">体重推移</h5>
                          </div>
                        </div>
                        <div class="col-6">
                          <h5 class="mb-0">1025</h5>
                        </div>
                        <div class="col-12">
                          <div id="chart-indonesia"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-xl-8">
                  <div class="card">
                    <div class="card-header">
                      <h4>最新の日記</h4>
                    </div>
                    <div class="card-body">
                      <div class="table-responsive">
                        <table class="table table-hover table-lg">
                          <thead>
                            <tr>
                              <th>日付け</th>
                              <th>内容</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td class="col-3">
                                <div class="d-flex align-items-center">
                                  <p class="font-bold ms-3 mb-0">日時</p>
                                </div>
                              </td>
                              <td class="col-auto">
                                <p class="mb-0">日記の内容を反映</p>
                                <!-- "卒業おめでとうございます" -->
                              </td>
                            </tr>
                            <tr>
                              <td class="col-3">
                                <div class="d-flex align-items-center">
                                  <p class="font-bold ms-3 mb-0">日時</p>
                                </div>
                              </td>
                              <td class="col-auto">
                                <p class="mb-0">日記の内容を反映</p>
                                <!-- デザインに関するフィードバック -->
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <div class="px-4">
                          <button class="btn btn-block mt-3">日記を投稿</button>
                          <!-- 会話を始めるボタン -->
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-3">
              <div class="card">
                <div class="card-body py-4 px-5">
                  <div class="d-flex align-items-center">
                    <div class="avatar avatar-xl">
                      <img src="${pageContext.request.contextPath}/images/faces/1.png" alt="Face 1" />
                    </div>
                    <div class="ms-3 name">
                      <h5 class="font-bold">マイアカウント</h5>
                      <h6 class="text-muted mb-0">@my_account</h6>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <h4>最近のコメントユーザー</h4>
                  <!-- ユーザーに届いた最新メッセージ -->
                </div>
                <div class="card-content pb-4">
                  <div class="recent-message d-flex px-4 py-3">
                    <div class="avatar avatar-lg">
                      <img src="assets/images/faces/4.jpg" />
                    </div>
                    <div class="name ms-4">
                      <h5 class="mb-1">鳳来 海斗</h5>
                      <h6 class="text-muted mb-0">@___sea10</h6>
                    </div>
                  </div>
                  <div class="recent-message d-flex px-4 py-3">
                    <div class="avatar avatar-lg">
                      <img src="assets/images/faces/5.jpg" />
                    </div>
                    <div class="name ms-4">
                      <h5 class="mb-1">柏 紅葉</h5>
                      <h6 class="text-muted mb-0">@pino123</h6>
                    </div>
                  </div>
                  <div class="recent-message d-flex px-4 py-3">
                    <div class="avatar avatar-lg">
                      <img src="assets/images/faces/1.jpg" />
                    </div>
                    <div class="name ms-4">
                      <h5 class="mb-1">瀬戸 結月</h5>
                      <h6 class="text-muted mb-0">@yuzu_pm</h6>
                    </div>
                  </div>
                  <div class="px-4">
                    <button class="btn btn-block mt-3">トークを開始</button>
                    <!-- 会話を始めるボタン -->
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header">
                  <h4>今日の栄養バランス</h4>
                </div>
                <div class="card-body">
                  <div id="chart-visitors-profile"></div>
                </div>
              </div>
            </div>
          </section>
        </div>
        <footer>
          <div class="footer clearfix mb-0 text-muted">
            <div class="float-start">
              <p>© 2025 Dashboard</p>
            </div>
            <div class="float-end">
              <p>Created by <span class="text-primary">aiko</span></p>
            </div>
          </div>
        </footer>
      </div>
    </div>

    <!-- 必要なJSファイル -->
    <script src="${pageContext.request.contextPath}/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendors/apexcharts/apexcharts.js"></script>
    <script src="${pageContext.request.contextPath}/js/pages/dashboard.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <!-- jQuery (Bootstrapの依存ライブラリ) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
