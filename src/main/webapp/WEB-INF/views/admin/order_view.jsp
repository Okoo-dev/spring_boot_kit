<!-- 테이블 템플릿 쓴거임 Css랑 js 파일 찾아서 다없애기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Kit.admin-page</title>

<!-- 파비콘 -->
<link rel="shortcut icon" type="image⁄x-icon"
	href="/admin/Dashio/img/favicon.ico">

<!-- Bootstrap core CSS -->
<link href="/admin/Dashio/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link href="/admin/Dashio/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="/admin/Dashio/css/style.css" rel="stylesheet">
<link href="/admin/Dashio/css/style-responsive.css" rel="stylesheet">

<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"></div>
			</div>

			<!--logo start-->
			<a href="/" class="logo"><b>Kit.<span>관리자</span></b></a>
			<!--logo end-->

			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="/">Logout</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<a href="#"><img src="/admin/Dashio/img/Kit2_size.png"
							class="img-circle" width="80"></a>
					</p>
					<h5 class="centered">관리자님</h5>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>회원 관리</span>
					</a>
						<ul class="sub">
							<li><a href="admin/usertable">회원 관리</a></li>
							<li><a href="admin/mail">이메일/sms발송</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>주문/배송관리</span>
					</a>
						<ul class="sub">
							<li><a href="admin/orderview">주문 리스트</a></li>
							<li><a href="#">배송 현황</a></li>
							<li><a href="#">주문 취소/반품</a></li>
						</ul></li>
					<li class="sub-menu"><a href="/admin/prodList"> <i
							class="fa fa-book"></i> <span>상품관리</span>
					</a></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>게시판 관리</span>
					</a>
						<ul class="sub">
							<li><a href="/admin/noticeList">공지사항</a></li>
							<li><a href="/admin/questionList">1:1 문의</a></li>
							<li><a href="/admin/eventList">이벤트</a></li>
							<li><a href="/admin/reviewList">리뷰</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>통계 관리</span>
					</a>
						<ul class="sub">
							<li><a href="#">방문자 분석</a></li>
							<li><a href="#">판매 분석</a></li>
							<li><a href="#">페이지 뷰 분석</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>프로모션 관리</span>
					</a>
						<ul class="sub">
							<li><a href="#">쿠폰 관리</a></li>
							<li><a href="#">배너/팝업창 관리</a></li>
						</ul></li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="col-lg-12 mt">
					<div class="row content-panel">
						<div class="col-lg-10 col-lg-offset-1">
							<div class="invoice-body">
								<div class="pull-left">
									<h1>Kit.</h1>
									<address>
										<strong>Admin Theme, Inc.</strong><br> 주소 : 서울 종로구 종로 69
										서울YMCA 7층<br> <abbr title="Phone">P:</abbr> (123)
										456-7890
									</address>
								</div>
								<!-- /pull-left -->
								<div class="pull-right">
									<h2>invoice</h2>
								</div>
								<!-- /pull-right -->
								<div class="clearfix"></div>
								<br> <br> <br>
								<div class="row">
									<div class="col-md-9">

										<!-- 배송받는사람 -->
										<h4>${order_detail_view.ordRecipient}</h4>

										<!-- 주문받는곳 -->
										<address>
											<strong>Enterprise Corp.</strong><br>
											${order_detail_view.ordLocation}<br> <abbr title="Phone">P:</abbr>
											(123) 456-7890
										</address>
									</div>
									<!-- /col-md-9 -->
									<div class="col-md-3">
										<br>
										<!-- <div>
											<div class="pull-left">INVOICE NO :</div>
											<div class="pull-right">000283</div>
											<div class="clearfix"></div>
										</div> -->
										<div>
											<!-- /col-md-3 -->
											<div class="pull-left">INVOICE DATE :</div>
											<div class="pull-right">${order_detail_view.ordDate}</div>
											<div class="clearfix"></div>
										</div>
										<!-- /row -->
										<br>
										<div class="well well-small green">
											<div class="pull-left">총 주문 금액 :</div>
											<div class="pull-right">8,000 USD</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- /invoice-body -->
								</div>
								<!-- /col-lg-10 -->
								<table class="table">
									<thead>
										<tr>
											<th style="width: 60px" class="text-center">수량</th>
											<th class="text-left">상품명</th>
											<th style="width: 140px" class="text-right">상품 가격</th>
											<th style="width: 90px" class="text-right">상품 총 가격</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="order" items="${order_detail_view}">
											<tr>
												<td class="text-center">1</td>
												<td>${order.prodName}</td>
												<%-- <td class="text-right">${vo.prodPrice}</td> --%>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="2" rowspan="4">
												<h4>Terms and Conditions</h4>
												<p>Thank you for your business. We do expect payment
													within 21 days, so please process this invoice within that
													time. There will be a 1.5% interest charge per month on
													late invoices.</p>
											<td class="text-right"><strong>총 주문 금액</strong></td>
											<td class="text-right">${order_detail_view.sumPrice}</td>
										</tr>
										<tr>
											<td class="text-right no-border"><strong>Shipping</strong></td>
											<td class="text-right">$0.00</td>
										</tr>
										<tr>
											<td class="text-right no-border">
												<div class="well well-small green">
													<strong>총 주문 금액</strong>
												</div>
											</td>
											<td class="text-right"><strong>${order_detail_view.sumPrice}</strong></td>
										</tr>
									</tbody>
								</table>
								<br> <br>
							</div>
						</div>
					</div>
				</div>
				<!--/col-lg-12 mt -->
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				<img class="img" src="/admin/Dashio/img/Kit2_size.png" />
				<div class="foo_div1">
					<span>(주)Kit.</span> <span> | </span> <span>대표 : 선진정형 </span> <span>
						| </span> <span>사업자 등록 번호 : 000-00-0000</span> <span> | </span>
					<p>주소 : 서울 종로구 종로 69 서울YMCA 7층.</p>
					<p>Kit.</p>
					<img src="/admin/Dashio/img/kakaotalk.png"> <img
						src="/admin/Dashio/img/google+.png"> <img
						src="/admin/Dashio/img/naver.png">
				</div>
				<p>
					&copy; Copyrights <strong>Kit.</strong>. All Rights Reserved
				</p>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/admin/Dashio/lib/jquery/jquery.min.js"></script>
	<script src="/admin/Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/admin/Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/admin/Dashio/lib/jquery.scrollTo.min.js"></script>
	<script src="/admin/Dashio/lib/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="/admin/Dashio/lib/common-scripts.js"></script>
	<!--script for this page-->

</body>

</html>
