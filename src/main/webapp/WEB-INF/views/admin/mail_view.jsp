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
<title>Dashio - Bootstrap Admin Template</title>

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
							<li><a href="/admin/userlist">회원 관리</a></li>
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
				<h3>
					<i class="fa fa-angle-right"></i> 메일 발송
				</h3>
				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<div id="message"></div>
						<form class="contact-form php-mail-form" role="form"
							action="/admin/mail" method="POST">

							<!-- 	<div class="form-group">
								<input type="name" name="name" class="form-control"
									id="contact-name" placeholder="보내시는분 이름을 적어주세요." data-rule="minlen:4"
									data-msg="Please enter at least 4 chars">
								<div class="validate"></div>
							</div> -->
							<div class="form-group">
								<input type="email" name="address" class="form-control"
									id="contact-email" placeholder="받는분 이메일 주소를 적어주세요."
									data-rule="email" data-msg="이메일 주소를 적어주세요.">
								<div class="validate"></div>
							</div>
							<div class="form-group">
								<input type="text" name="title" class="form-control"
									id="contact-subject" placeholder="제목을 적어주세요."
									data-rule="required" data-msg="제목을 적어주세요.">
								<div class="validate"></div>
							</div>

							<div class="form-group">
								<textarea class="form-control" name="message"
									id="contact-message" placeholder="내용을 적어주세요." rows="5"
									data-rule="required" data-msg="내용을 적어주세요."></textarea>
								<div class="validate"></div>
							</div>

							<div class="loading"></div>
							<div class="error-message"></div>
							<div class="sent-message">발송완료!!</div>

							<div class="form-send">
								<button type="submit" class="btn btn-large btn-primary">보내기</button>
							</div>

						</form>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-6">
						<h4 class="title">Contact Details</h4>
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. Lorem Ipsum has been the industry"s
							standard dummy text ever since the 1500s. Lorem Ipsum is simply
							dummy text of the printing and typesetting industry.</p>
						<ul class="contact_details">
							<li><i class="fa fa-envelope-o"></i> info@yoursite.com</li>
							<li><i class="fa fa-phone-square"></i> +34 5565 6555</li>
							<li><i class="fa fa-home"></i> Some Fine Address, 887,
								Madrid, Spain.</li>
						</ul>
						<!-- contact_details -->
					</div>
				</div>
				<!-- /row -->


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
	<script src="/admin/Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/admin/Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/admin/Dashio/lib/jquery.scrollTo.min.js"></script>
	<script src="/admin/Dashio/lib/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="/admin/Dashio/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="/admin/Dashio/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<!--custom switch-->
	<script src="/admin/Dashio/lib/bootstrap-switch.js"></script>
	<!--custom tagsinput-->
	<script src="/admin/Dashio/lib/jquery.tagsinput.js"></script>

	<!--Contactform Validation-->
	<script src="/admin/Dashio/lib/php-mail-form/validate.js"></script>

</body>

</html>
