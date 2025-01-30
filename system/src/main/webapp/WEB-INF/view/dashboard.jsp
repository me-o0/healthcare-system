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
<body>
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
                                                <h6 class="text-muted font-semibold">クリックして記録</h6>
                                                <h6 class="font-extrabold mb-0">朝食</h6>
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
                                                <h6 class="text-muted font-semibold">クリックして記録</h6>
                                                <h6 class="font-extrabold mb-0">昼食</h6>
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
                                                <h6 class="text-muted font-semibold">クリックして記録</h6>
                                                <h6 class="font-extrabold mb-0">夕食</h6>
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
                                                <h6 class="text-muted font-semibold">クリックして記録</h6>
                                                <h6 class="font-extrabold mb-0">間食</h6>
                                            </div>
                                        </div>
                                    </div>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- 食事選択フォーム (データベースに登録済みの食事を選択) -->
            <div id="breakfastForm" class="collapse card">
                <form action="mealServlet" method="POST">
                    <input type="hidden" name="meal_type" value="breakfast">
                    <label for="meal_select">朝食を選んでください：</label>
                    <select name="meal_id" id="meal_select" class="form-control">
                        <c:forEach var="mealOption" items="${mealOptions}">
                            <option value="${mealOption.foodId}">${mealOption.name} - カロリー: ${mealOption.calories} kcal</option>
                        </c:forEach>
                    </select>
                    <label for="eat_date">食べた日：</label>
                    <input type="date" name="eat_date" class="form-control" required>
                    <input type="submit" value="朝食を記録" class="btn btn-primary mt-2">
                </form>

                <!-- 食事新規登録フォーム (朝食用) -->
                <div class="mt-4 card">
                    <h5>朝食新規登録</h5>
                    <form action="mealServlet" method="POST">
                        <input type="hidden" name="meal_type" value="breakfast">
                        <div class="form-group">
                            <label for="meal_name">食事名</label>
                            <input type="text" name="meal_name" id="meal_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_calories">カロリー</label>
                            <input type="number" name="meal_calories" id="meal_calories" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_protein">タンパク質</label>
                            <input type="number" name="meal_protein" id="meal_protein" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_fat">脂質</label>
                            <input type="number" name="meal_fat" id="meal_fat" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_carbs">炭水化物</label>
                            <input type="number" name="meal_carbs" id="meal_carbs" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_category">カテゴリー</label>
                            <select name="meal_category" id="meal_category" class="form-control">
                                <option value="1">自炊</option>
                                <option value="2">外食</option>
                                <option value="3">食材</option>
                            </select>
                        </div>
                        <input type="submit" value="朝食を新規登録" class="btn btn-success mt-3">
                    </form>
                </div>
            </div>

            <div id="lunchForm" class="collapse card">
                <form action="mealServlet" method="POST">
                    <input type="hidden" name="meal_type" value="lunch">
                    <label for="meal_select">昼食を選んでください：</label>
                    <select name="meal_id" id="meal_select" class="form-control">
                        <c:forEach var="mealOption" items="${mealOptions}">
                            <option value="${mealOption.foodId}">${mealOption.name} - カロリー: ${mealOption.calories} kcal</option>
                        </c:forEach>
                    </select>
                    <label for="eat_date">食べた日：</label>
                    <input type="date" name="eat_date" class="form-control" required>
                    <input type="submit" value="昼食を記録" class="btn btn-primary mt-2">
                </form>

                <!-- 食事新規登録フォーム (昼食用) -->
                <div class="mt-4 card">
                    <h5>昼食新規登録</h5>
                    <form action="mealServlet" method="POST">
                        <input type="hidden" name="meal_type" value="lunch">
                        <div class="form-group">
                            <label for="meal_name">食事名</label>
                            <input type="text" name="meal_name" id="meal_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_calories">カロリー</label>
                            <input type="number" name="meal_calories" id="meal_calories" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_protein">タンパク質</label>
                            <input type="number" name="meal_protein" id="meal_protein" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_fat">脂質</label>
                            <input type="number" name="meal_fat" id="meal_fat" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_carbs">炭水化物</label>
                            <input type="number" name="meal_carbs" id="meal_carbs" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_category">カテゴリー</label>
                            <select name="meal_category" id="meal_category" class="form-control">
                                <option value="1">自炊</option>
                                <option value="2">外食</option>
                                <option value="3">食材</option>
                            </select>
                        </div>
                        <input type="submit" value="昼食を新規登録" class="btn btn-success mt-3">
                    </form>
                </div>
            </div>

            <div id="dinnerForm" class="collapse card">
                <form action="mealServlet" method="POST">
                    <input type="hidden" name="meal_type" value="dinner">
                    <label for="meal_select">夕食を選んでください：</label>
                    <select name="meal_id" id="meal_select" class="form-control">
                        <c:forEach var="mealOption" items="${mealOptions}">
                            <option value="${mealOption.foodId}">${mealOption.name} - カロリー: ${mealOption.calories} kcal</option>
                        </c:forEach>
                    </select>
                    <label for="eat_date">食べた日：</label>
                    <input type="date" name="eat_date" class="form-control" required>
                    <input type="submit" value="夕食を記録" class="btn btn-primary mt-2">
                </form>

                <!-- 食事新規登録フォーム (夕食用) -->
                <div class="mt-4 card">
                    <h5>夕食新規登録</h5>
                    <form action="mealServlet" method="POST">
                        <input type="hidden" name="meal_type" value="dinner">
                        <div class="form-group">
                            <label for="meal_name">食事名</label>
                            <input type="text" name="meal_name" id="meal_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_calories">カロリー</label>
                            <input type="number" name="meal_calories" id="meal_calories" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_protein">タンパク質</label>
                            <input type="number" name="meal_protein" id="meal_protein" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_fat">脂質</label>
                            <input type="number" name="meal_fat" id="meal_fat" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_carbs">炭水化物</label>
                            <input type="number" name="meal_carbs" id="meal_carbs" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_category">カテゴリー</label>
                            <select name="meal_category" id="meal_category" class="form-control">
                                <option value="1">自炊</option>
                                <option value="2">外食</option>
                                <option value="3">食材</option>
                            </select>
                        </div>
                        <input type="submit" value="夕食を新規登録" class="btn btn-success mt-3">
                    </form>
                </div>
            </div>

            <div id="snackForm" class="collapse card">
                <form action="mealServlet" method="POST">
                    <input type="hidden" name="meal_type" value="snack">
                    <label for="meal_select">間食を選んでください：</label>
                    <select name="meal_id" id="meal_select" class="form-control">
                        <c:forEach var="mealOption" items="${mealOptions}">
                            <option value="${mealOption.foodId}">${mealOption.name} - カロリー: ${mealOption.calories} kcal</option>
                        </c:forEach>
                    </select>
                    <label for="eat_date">食べた日：</label>
                    <input type="date" name="eat_date" class="form-control" required>
                    <input type="submit" value="間食を記録" class="btn btn-primary mt-2">
                </form>

                <!-- 食事新規登録フォーム (間食用) -->
                <div class="mt-4 card">
                    <h5>間食新規登録</h5>
                    <form action="mealServlet" method="POST">
                        <input type="hidden" name="meal_type" value="snack">
                        <div class="form-group">
                            <label for="meal_name">食事名</label>
                            <input type="text" name="meal_name" id="meal_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_calories">カロリー</label>
                            <input type="number" name="meal_calories" id="meal_calories" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_protein">タンパク質</label>
                            <input type="number" name="meal_protein" id="meal_protein" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_fat">脂質</label>
                            <input type="number" name="meal_fat" id="meal_fat" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_carbs">炭水化物</label>
                            <input type="number" name="meal_carbs" id="meal_carbs" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="meal_category">カテゴリー</label>
                            <select name="meal_category" id="meal_category" class="form-control">
                                <option value="1">自炊</option>
                                <option value="2">外食</option>
                                <option value="3">食材</option>
                            </select>
                        </div>
                        <input type="submit" value="間食を新規登録" class="btn btn-success mt-3">
                    </form>
                </div>
            </div>
        </div>
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
