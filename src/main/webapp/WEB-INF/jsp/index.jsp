<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<meta name="theme-color" content="#7952b3">
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

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
	
<link rel="stylesheet" type="text/css"  href="https://cdn.datatables.net/buttons/1.4.0/css/buttons.dataTables.min.css" />


<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
	
<script src="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.0/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.0/js/buttons.flash.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.0/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.0/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.4.0/css/buttons.dataTables.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
<!-- <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script> -->
<script src="/resources/js/vfs_fonts.js"></script>

<script>
	$(function() {

		$('#example').DataTable({
			processing : true,
			serverSide : true,
			order:false,
			lengthChange:false,
			ajax : 'paging',
			dom: 'Bfrtip',
			buttons: [
					{  extend: 'csv', 			//輸出格式
			           charset: 'UTF-8',		//UTF-8
			           bom: true,
			           filename: 'CsvTest',
			           title: 'CsvTest'
			        },
			        {  extend: 'copy', 			//輸出格式
				           charset: 'UTF-8',		//UTF-8
				           bom: true,
				           filename: 'CopyTest',
				           title: 'CopyTest'
				     },
				     {  extend: 'excel', 			//輸出格式
				           charset: 'UTF-8',		//UTF-8
				           bom: true,
				           filename: 'excelTest',
				           title: 'excelTest'
				     },
				     {  extend: 'pdfHtml5', 			//輸出格式
				           charset: 'UTF-8',		//UTF-8
				           bom: true,
				           filename: 'pdfTest',
				           title: 'pdfTest',
				           download: 'open'
				     },
				     {  extend: 'print', 			//輸出格式
				           charset: 'UTF-8',		//UTF-8
				           bom: true,
				           filename: 'printTest',
				           title: 'printTest'
				     }		
	        ],
	        
			columns : [ 
				{data : 'id' , title:'主鍵'}, 
				{data : 'fmtBeginTime', title:'開始日期'}, 
				{data : 'title', title:'主旨'}, 
				{data : 'content', title:'內容', render:function( content ){  //content == null 的話，經過ToBoolean()判斷，null的boolean() 會是false
					if (content && content.length > 20){
						var content = content.substring(0,20);
					} 
					return content + "...更多內容";
				}}, 
				{data : "id", title:"功能", render:function( content ){
					return "<button onClick='editRow("+ content + ")'>編輯</button><button onClick='delRow(" + content + ")'>刪除</button>"
				}} 
			],
		});
	});
		function delRow(id){
			alert(id);
			
			$.ajax({
				url:'http://localhost:8080/delete',
				type:'GET',
				contentType:'application/json',
				data:{	
					"id":id,
				},
				success: function(result){
					alert(result);
// 					parent.location.reload()
					$('#example').DataTable().ajax.reload();
				},
				error: function(result){
					alert(result);
				}
			})
		}
		
		function editRow(id){
			alert(id);
			let data = {
					"id":id
			}
			location.href="/edit?id="+id;
				
		}

</script>


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
<link href="/resources/css/dashboard.css" rel="stylesheet">
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
						<li class="nav-item"><a class="nav-link" href="/orders">
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
				<div class="table-responsive">
					<!-- 					<table class="table table-striped table-sm"> -->
					<!-- 						<thead> -->
					<!-- 							<tr> -->
					<!-- 								<th scope="col">#</th> -->
					<!-- 								<th scope="col">開始時間</th> -->
					<!-- 								<th scope="col">項目</th> -->
					<!-- 								<th scope="col">內容</th> -->
					<!-- 							</tr> -->
					<!-- 						</thead> -->
					<!-- 						<tbody> -->
					<%-- 							<c:forEach var="info" items="${currentPage.content}"> --%>
					<!-- 								<tr> -->
					<%-- 									<td style="white-space: nowrap; padding: 10px;">${info.id}</td> --%>
					<%-- 									<td style="white-space: nowrap; padding: 10px;">${info.fmtBeginTime}</td> --%>
					<!-- 									<td style="white-space: nowrap; padding: 10px;"><a -->
					<%-- 										href="${info.link}"> ${info.title}</a></td> --%>
					<%-- 									<td style="padding: 10px;">${info.content}</td> --%>
					<!-- 								</tr> -->
					<%-- 							</c:forEach> --%>
					<!-- 						</tbody> -->
					<!-- 					</table> -->
					<!-- 					<nav aria-label="Page navigation example"> -->
					<!-- 						<ul class="pagination justify-content-center"> -->

					<%-- 							<c:forEach var="current" begin="1" --%>
					<%-- 								end="${currentPage.totalPages}"> --%>
					<!-- 								<li class="page-item"><a class="page-link" -->
					<%-- 									href="index?page=${current}">${current}</a></li> --%>
					<%-- 							</c:forEach> --%>

					<!-- 						</ul> -->
					<!-- 					</nav> -->
					<table id="example" class="display" style="width: 100%">
						
						
						
					</table>
				</div>
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
	<script src="/resources/js/dashboard.js"></script>
</body>
</html>