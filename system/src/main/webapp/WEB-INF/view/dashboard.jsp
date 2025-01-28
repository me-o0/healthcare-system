<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ダッシュボード - Mazer 管理ダッシュボード</title>

    <!-- フォントやスタイルシートのリンク -->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet" />
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
                <a href="index.html"><img class="sidebar-logo" src="assets/images/logo/logo.png" alt="ロゴ" srcset="" /></a>
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
                <a href="https://github.com/" class="sidebar-link">
                  <i class="bi bi-cash"></i>
                  <span>寄付</span>
                </a>
              </li>
              <li class="sidebar-item">
                <a href="https://github.com/zuramai/mazer#donate" class="sidebar-link">
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

        <div class="page-heading">
          <h3>食事記録</h3>
        </div>
        <div class="page-content">
          <section class="row">
            <div class="col-12 col-lg-9">
              <div class="row">
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <button class="card-btn">
                      <div class="card-body px-3 py-4-5">
                        <div class="row">
                          <div class="col-md-4">
                            <div class="stats-icon purple">
                              <i class="iconly-boldShow"></i>
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
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <button class="card-btn">
                      <div class="card-body px-3 py-4-5">
                        <div class="row">
                          <div class="col-md-4">
                            <div class="stats-icon blue">
                              <i class="iconly-boldProfile"></i>
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
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <button class="card-btn">
                      <div class="card-body px-3 py-4-5">
                        <div class="row">
                          <div class="col-md-4">
                            <div class="stats-icon green">
                              <i class="iconly-boldAdd-User"></i>
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
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <button class="card-btn">
                      <div class="card-body px-3 py-4-5">
                        <div class="row">
                          <div class="col-md-4">
                            <div class="stats-icon red">
                              <i class="iconly-boldBookmark"></i>
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
                      <img src="assets/images/faces/1.png" alt="Face 1" />
                    </div>
                    <div class="ms-3 name">
                      <h5 class="font-bold">マイアカウント</h5>
                      <h6 class="text-muted mb-0">@pompom</h6>
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
                      <h5 class="mb-1">Hank Schrader</h5>
                      <h6 class="text-muted mb-0">@johnducky</h6>
                    </div>
                  </div>
                  <div class="recent-message d-flex px-4 py-3">
                    <div class="avatar avatar-lg">
                      <img src="assets/images/faces/5.jpg" />
                    </div>
                    <div class="name ms-4">
                      <h5 class="mb-1">Dean Winchester</h5>
                      <h6 class="text-muted mb-0">@imdean</h6>
                    </div>
                  </div>
                  <div class="recent-message d-flex px-4 py-3">
                    <div class="avatar avatar-lg">
                      <img src="assets/images/faces/1.jpg" />
                    </div>
                    <div class="name ms-4">
                      <h5 class="mb-1">John Dodol</h5>
                      <h6 class="text-muted mb-0">@dodoljohn</h6>
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
              <p>Created by <span class="text-primary">YourName</span></p>
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
  </body>
</html>
