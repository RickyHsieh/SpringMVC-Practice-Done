<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Dashboard Template · Bootstrap v5.1</title>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/dashboard/">


<!-- Bootstrap core CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="icon"
	href="https://getbootstrap.com/docs/5.1/assets/img/favicons/favicon.ico">
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<meta name="theme-color" content="#7952b3">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>



<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">
</head>
<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
			name</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">Sign out</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#"> <span data-feather="home"></span>
								首頁
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/order">
								<span data-feather="file"></span> 訂單查詢
						</a></li>
						<li class="nav-item"><a class="nav-link" href="product.html">
								<span data-feather="shopping-cart"></span> 產品維護
						</a></li>
						<li class="nav-item"><a class="nav-link" href="customer.html">
								<span data-feather="users"></span> 客戶查詢
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="bar-chart-2"></span> 統計報表
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="layers"></span> 批次查詢
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Saved reports</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> 月報表
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> 週報表
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> 日報表
						</a></li>
					</ul>
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">系統公告</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">匯出
								XLS</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">匯出
								PDF</button>
						</div>
					</div>
				</div>
				<!-- 資料 1 -->
				<c:set var="total" value="0"></c:set>
				<c:set var="count" value="0"></c:set>
				<c:forEach var="order" items="${orders}">
				<c:set var="total" value="${total + 1}"></c:set>
				<c:set var="count" value="${count + 1}"></c:set>
					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<thead>
								<tr>
									<th scope="col" class="bg-dark text-light">訂單編號</th>
									<th scope="col" class="bg-dark text-light">日期</th>
									<th scope="col" class="bg-dark text-light">訂單狀態</th>
									<th scope="col" class="bg-dark text-light">總價</th>
									<th scope="col" class="bg-dark text-light">付款</th>
									<th scope="col" class="bg-dark text-light">配送狀態</th>
									<th scope="col" class="bg-dark text-light">發票</th>
									<th scope="col" class="bg-dark text-light">說明</th>
								</tr>
							</thead>
							<tbody>
								<!-- 訂單 -->

								<tr>
									<td style="white-space: nowrap; padding: 10px;">${order.orderNo}</td>
									<td style="white-space: nowrap; padding: 10px;">${order.fmtOrderDate}</td>
									<td style="padding: 10px;">${order.orderStatus}</td>
									<td style="padding: 10px;">$ ${order.fmtTotalAmt}</td>
									<td style="white-space: nowrap; padding: 10px;">${order.payType}(付款狀態)</td>
									<td style="white-space: nowrap; padding: 10px;">物流庫出貨</td>
									<td style="white-space: nowrap; padding: 10px;">${order.invoiceNo}(日期：${order.fmtInvoiceDate})</td>
									<td style="white-space: nowrap; padding: 10px;">${order.remark}</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="8"></td>
								</tr>
							</tfoot>
						</table>
					</div>

					<p>
						<a class="btn btn-dark btn-sm" id="OrderDtl"
							data-bs-toggle="collapse" href="#dtl-${total}" role="button"
							aria-expanded="false" aria-controls="collapseExample"> 更多 </a>
					</p>

					<hr style="border-top: 1px dashed black;">
			
			
				<div class="collapse" id="dtl-${count}">
					<div class="card card-body">
						<table class="table table-striped table-sm">
							<tbody>
								<!-- 訂單細節 -->
							
								<c:forEach var="orderDtl" items="${order.mvcOrderDtlEntity}">
								
								<tr>
									<td style="white-space: nowrap; padding: 10px;">${orderDtl.mvcProductEntity.prodName}</td>
									<td style="white-space: nowrap; padding: 10px;">${orderDtl.buyItem} 件</td>
									<td style="padding: 10px;">$ ${orderDtl.fmtBuyTotalAmt}</td>
									<td style="padding: 10px;">$ ${orderDtl.fmtPackDate} 出貨</td>
									<td style="white-space: nowrap; padding: 10px;">我要退貨</td>
									<td style="white-space: nowrap; padding: 10px;"><button
											class="btn btn-sm btn-info">商品快照</button></td>
								</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</c:forEach>
			
				<!-- END 資料 1 -->


			</main>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="dashboard.js"></script>
</body>
</html>