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
<link rel="stylesheet" type="text/css"
	href="/admin/Dashio/lib/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/admin/Dashio/lib/bootstrap-daterangepicker/daterangepicker.css" />
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
							<li><a href="/admin/usertable">회원 관리</a></li>
							<li><a href="/admin/mail">이메일/sms발송</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>주문/배송관리</span>
					</a>
						<ul class="sub">
							<li><a href="/admin/orderlist">주문 리스트</a></li>
							<li><a href="#">배송 현황</a></li>
							<li><a href="#">주문 취소/반품</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>상품관리</span>
					</a>
						<ul class="sub">
							<li><a href="/admin/prodlist">상품 등록</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>게시판 관리</span>
					</a>
						<ul class="sub">
							<li><a href="#">리뷰 관리</a></li>
							<li><a href="#">이벤트 관리</a></li>
							<li><a href="form_validation.html">1:1 문의 관리</a></li>
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
				<h3>
					<i class="fa fa-angle-right"></i> 상품 등록
				</h3>
				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<i class="fa fa-angle-right"></i>
							<form class="form-horizontal style-form" action="prodUpload"
								method="post">

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 이름</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodName">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">재고량</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodStock">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 분류</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodCategory">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 가격</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodPrice">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">식사량</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodServings">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 조리 시간</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodCookingTime">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 준비 시간</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="prodPrepareTime">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">상품 설명</label>
									<div class="col-sm-10">
										<textarea type="text" class="form-control" name="prodComment"></textarea>
									</div>
								</div>
								<table>
									<tr>
										<td colspan="2"><input type="submit" value="상품등록"
											class="btn btn-round btn-success"> &nbsp;&nbsp; <a
											href="/admin/prodList"><button type="button"
													class="btn btn-round btn-info">목록보기</button></a></td>
									</tr>
								</table>
							</form>

						</div>
					</div>
				</div>

				<!-- /row -->
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
	<script src="/admin/Dashio/lib/jquery/scroll.js"></script>
	<script src="/admin/Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/admin/Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>

	<!-- 사이드바 관련 js 파일 -->
	<script src="/admin/Dashio/lib/jquery.scrollTo.min.js"></script>

	<!-- 정체를 모르겠음 -->
	<!-- <script src="/admin/Dashio/lib/jquery.nicescroll.js"
		type="text/javascript"></script> -->
	<!--common script for all pages-->
	<script src="/admin/Dashio/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="/admin/Dashio/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<!--custom switch-->
	<script src="/admin/Dashio/lib/bootstrap-switch.js"></script>
	<!--custom tagsinput-->
	<script src="/admin/Dashio/lib/jquery.tagsinput.js"></script>
	<!--custom checkbox & radio-->
	<script type="text/javascript"
		src="/admin/Dashio/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	<script src="/admin/Dashio/lib/form-component.js"></script>

</body>

</html>
