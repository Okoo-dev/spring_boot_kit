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
	href="/admin/Dashio/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="/admin/Dashio/lib/gritter/css/jquery.gritter.css" />
<!-- Custom styles for this template -->
<link href="/admin/Dashio/css/style.css" rel="stylesheet">
<link href="/admin/Dashio/css/style-responsive.css" rel="stylesheet">
<script src="/admin/Dashio/lib/chart-master/Chart.js"></script>

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
			<a href="/admin/index" class="logo"><b>Kit.<span>관리자</span></b></a>
			<!--logo end-->

			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="/login" onclick="confirmLogout();">로그아웃</a></li>
					<li><a class="logout" href="/menu" >홈페이지</a></li>
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
				<div class="row">
					<div class="col-lg-9 main-chart">
						<!--CUSTOM CHART START -->
						<div class="border-head">
							<h3>관리자 메인 페이지</h3>
						</div>
						<div class="col-lg-12">
							<div class="content-panel">
								<h4>
									<i class="fa fa-angle-right"></i> Doughnut
								</h4>
								<div class="panel-body text-center">
									<canvas id="doughnut" height="300" width="400"></canvas>
								</div>

								<h4>
									<i class="fa fa-angle-right"></i> Line
								</h4>
								<div class="panel-body text-center">
									<canvas id="line" height="300" width="400"></canvas>
								</div>

								<h4>
									<i class="fa fa-angle-right"></i> Line
								</h4>
								<div class="custom-bar-chart">
									<ul class="y-axis">
										<li><span>10.000</span></li>
										<li><span>8.000</span></li>
										<li><span>6.000</span></li>
										<li><span>4.000</span></li>
										<li><span>2.000</span></li>
										<li><span>0</span></li>
									</ul>
									<div class="bar">
										<div class="title">JAN</div>
										<div class="value tooltips" data-original-title="8.500"
											data-toggle="tooltip" data-placement="top">85%</div>
									</div>
									<div class="bar ">
										<div class="title">FEB</div>
										<div class="value tooltips" data-original-title="5.000"
											data-toggle="tooltip" data-placement="top">50%</div>
									</div>
									<div class="bar ">
										<div class="title">MAR</div>
										<div class="value tooltips" data-original-title="6.000"
											data-toggle="tooltip" data-placement="top">60%</div>
									</div>
									<div class="bar ">
										<div class="title">APR</div>
										<div class="value tooltips" data-original-title="4.500"
											data-toggle="tooltip" data-placement="top">45%</div>
									</div>
									<div class="bar">
										<div class="title">MAY</div>
										<div class="value tooltips" data-original-title="3.200"
											data-toggle="tooltip" data-placement="top">32%</div>
									</div>
									<div class="bar ">
										<div class="title">JUN</div>
										<div class="value tooltips" data-original-title="6.200"
											data-toggle="tooltip" data-placement="top">62%</div>
									</div>
									<div class="bar">
										<div class="title">JUL</div>
										<div class="value tooltips" data-original-title="7.500"
											data-toggle="tooltip" data-placement="top">75%</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /col-lg-9 END SECTION MIDDLE -->
					<!-- 우측 사이드바 -->
					<div class="col-lg-3 ds">
						<!--COMPLETED ACTIONS DONUTS CHART-->
						<div class="donut-main">
							<h4>COMPLETED ACTIONS & PROGRESS</h4>
							<canvas id="newchart" height="130" width="130"></canvas>
							<script>
								var doughnutData = [ {
									value : 70,
									color : "#4ECDC4"
								}, {
									value : 30,
									color : "#fdfdfd"
								} ];
								var myDoughnut = new Chart(document
										.getElementById("newchart").getContext(
												"2d")).Doughnut(doughnutData);
							</script>
						</div>
						<!--NEW EARNING STATS -->
						<div class="panel terques-chart">
							<div class="panel-body">
								<div class="chart">
									<div class="centered">
										<span>TODAY EARNINGS</span> <strong>$ 890,00 | 15%</strong>
									</div>
									<br>
									<div class="sparkline" data-type="line" data-resize="true"
										data-height="75" data-width="90%" data-line-width="1"
										data-line-color="#fff" data-spot-color="#fff"
										data-fill-color="" data-highlight-line-color="#fff"
										data-spot-radius="4"
										data-data="[200,135,667,333,526,996,564,123,890,564,455]"></div>
								</div>
							</div>
						</div>
						<!--new earning end-->
						<!-- RECENT ACTIVITIES SECTION -->
						<h4 class="centered mt">RECENT ACTIVITY</h4>
						<!-- First Activity -->
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<muted>Just Now</muted>
									<br /> <a href="#">Paul Rudd</a> purchased an item.<br />
								</p>
							</div>
						</div>
						<!-- Second Activity -->
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<muted>2 Minutes Ago</muted>
									<br /> <a href="#">James Brown</a> subscribed to your
									newsletter.<br />
								</p>
							</div>
						</div>
						<!-- Third Activity -->
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<muted>3 Hours Ago</muted>
									<br /> <a href="#">Diana Kennedy</a> purchased a year
									subscription.<br />
								</p>
							</div>
						</div>
						<!-- Fourth Activity -->
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							<div class="details">
								<p>
									<muted>7 Hours Ago</muted>
									<br /> <a href="#">Brando Page</a> purchased a year
									subscription.<br />
								</p>
							</div>
						</div>
						<!-- USERS ONLINE SECTION -->
						<h4 class="centered mt">TEAM MEMBERS ONLINE</h4>
						<!-- First Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-divya.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DIVYA MANIAN</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- Second Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-sherman.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DJ SHERMAN</a><br />
									<muted>I am Busy</muted>
								</p>
							</div>
						</div>
						<!-- Third Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-danro.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">DAN ROGERS</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- Fourth Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="img/ui-zac.jpg" width="35px"
									height="35px" align="">
							</div>
							<div class="details">
								<p>
									<a href="#">Zac Sniders</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<!-- CALENDAR-->
						<div id="calendar" class="mb">
							<div class="panel green-panel no-margin">
								<div class="panel-body">
									<div id="date-popover" class="popover top"
										style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
										<div class="arrow"></div>
										<h3 class="popover-title" style="disadding: none;"></h3>
										<div id="date-popover-content" class="popover-content"></div>
									</div>
									<div id="my-calendar"></div>
								</div>
							</div>
						</div>
						<!-- / calendar -->
					</div>
				</div>

				<!-- /row -->
			</section>
		</section>
		<!-- top 스르르르르륵 올라가는거임 -->
		<a href="#" class="top">
			<button type="button" class="btn btn-dark">top</button>
		</a>
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
		<!-- footer end -->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/admin/Dashio/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript" language="javascript"
		src="lib/advanced-datatable/js/jquery.js"></script>
	<script src="/admin/Dashio/lib/jquery/scroll.js"></script>
	<script src="/admin/Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/admin/Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/admin/Dashio/lib/jquery.scrollTo.min.js"></script>
	<script src="/admin/Dashio/lib/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="/admin/Dashio/lib/jquery.sparkline.js"></script>

	<script type="text/javascript" language="javascript"
		src="/admin/Dashio/lib/advanced-datatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/advanced-datatable/js/DT_bootstrap.js"></script>
	<!--common script for all pages-->
	<script src="/admin/Dashio/lib/common-scripts.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="/admin/Dashio/lib/gritter-conf.js"></script>

	<!-- chart.js -->
	<script src="/admin/Dashio/lib/chart-master/Chart.js"></script>
	<script src="/admin/Dashio/lib/chartjs-conf.js"></script>

	<!--script for this page-->
	<script type="text/javascript">
		/* Formating function for row details */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
			sOut += '<tr><td>Rendering engine:</td><td>' + aData[1] + ' '
					+ aData[4] + '</td></tr>';
			sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
			sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
			sOut += '</table>';

			return sOut;
		}

		$(document).ready(
				function() {
					/*
					 * Insert a 'details' column to the table
					 */
					var nCloneTh = document.createElement('th');
					var nCloneTd = document.createElement('td');
					nCloneTd.className = "center";

					$('#hidden-table-info thead tr').each(function() {
						this.insertBefore(nCloneTh, this.childNodes[0]);
					});

					$('#hidden-table-info tbody tr').each(
							function() {
								this.insertBefore(nCloneTd.cloneNode(true),
										this.childNodes[0]);
							});

					/*
					 * Initialse DataTables, with no sorting on the 'details' column
					 */
					var oTable = $('#hidden-table-info').dataTable({
						"aoColumnDefs" : [ {
							"bSortable" : false,
							"aTargets" : [ 0 ]
						} ],
						"aaSorting" : [ [ 1, 'asc' ] ]
					});
				});
	</script>

	<script type="text/javascript">
		function confirmLogout() {
			if (confirm("정말 로그아웃 하시겠습니까?")) {
				alert("로그아웃되셨습니다.");

			} else {
				alert("취소되었습니다.");

			}
		}
	</script>





</body>

</html>
