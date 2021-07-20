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

<link rel="stylesheet"
	href="/admin/Dashio/lib/advanced-datatable/css/DT_bootstrap.css" />

<!-- Custom styles for this template -->
<link href="/admin/Dashio/css/style.css" rel="stylesheet">

<!-- 사이드바 css -->
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
					<i class="fa fa-angle-right"></i> 이벤트
				</h3>
				<div class="row">

					<!-- page start-->
					<div class="content-panel">
						<div class="adv-table">
							<table cellpadding="0" cellspacing="0" border="0"
								class="display table table-bordered" id="hidden-table-info">
								<thead>
									<tr>
										<td><input id="allCheck" type="checkbox" name="allCheck" /></td>
										<td>글 번호</td>
										<td>글 카테고리</td>
										<td>글 제목</td>
										<td>작성 날짜</td>
										<td>조회수</td>
										<td>작성자</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${eventList}">
										<tr>
											<td><input name="RowCheck" type="checkbox"
												value="${list.brdId}"></td>
											<td>${list.brdId}</td>
											<td>${list.brdName}</td>
											<td><a href="/admin/noticeList?brdId=${list.brdId}">${list.brdTitle}</a></td>
											<td>${list.brdDate}</td>
											<td>${list.brdHit}</td>
											<td>${list.brdUserid}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<table>
								<tr>
									<td colspan="2"><input type="button" value="선택 삭제"
										class="btn btn-default" onclick="deleteValue();">
										&nbsp;&nbsp;<a href="#"><button type="button"
												class="btn btn-default">이벤트 등록 하기</button></a></td>
								</tr>
							</table>
						</div>
					</div>
					<!-- page end-->
				</div>
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
		src="/admin/Dashio/lib/advanced-datatable/js/jquery.js"></script>

	<script src="/admin/Dashio/lib/jquery/scroll.js"></script>

	<script src="/admin/Dashio/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/admin/Dashio/lib/jquery.dcjqaccordion.2.7.js"></script>

	<!-- 사이드바 드롭다운 -->
	<script src="/admin/Dashio/lib/jquery.scrollTo.min.js"></script>
	<script src="/admin/Dashio/lib/jquery.nicescroll.js"
		type="text/javascript"></script>

	<script type="text/javascript" language="javascript"
		src="/admin/Dashio/lib/advanced-datatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="/admin/Dashio/lib/advanced-datatable/js/DT_bootstrap.js"></script>


	<!--common script for all pages-->
	<script src="/admin/Dashio/lib/common-scripts.js"></script>
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

		$(document)
				.ready(
						function() {

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

							/* Add event listener for opening and closing details
							 * Note that the indicator for showing which row is open is not controlled by DataTables,
							 * rather it is done here
							 */
							$('#hidden-table-info tbody td img')
									.live(
											'click',
											function() {
												var nTr = $(this).parents('tr')[0];
												if (oTable.fnIsOpen(nTr)) {
													/* This row is already open - close it */
													this.src = "lib/advanced-datatable/media/images/details_open.png";
													oTable.fnClose(nTr);
												} else {
													/* Open this row */
													this.src = "lib/advanced-datatable/images/details_close.png";
													oTable
															.fnOpen(
																	nTr,
																	fnFormatDetails(
																			oTable,
																			nTr),
																	'details');
												}
											});
						});
	</script>

	<script type="text/javascript">
		$(function() {
			var chkObj = document.getElementsByName("RowCheck");
			var rowCnt = chkObj.length;

			$("input[name='allCheck']").click(function() {
				var chk_listArr = $("input[name='RowCheck']");
				for (var i = 0; i < chk_listArr.length; i++) {
					chk_listArr[i].checked = this.checked;
				}
			});

			$("input[name='RowCheck']").click(function() {
				if ($("input[name='RowCheck']:checked").length == rowCnt) {
					$("input[name='allCheck']")[0].checked = true;
				} else {
					$("input[name='allCheck']")[0].checked = false;
				}
			});
		});

		function deleteValue() {
			var url = "prodDelete";
			var valueArr = new Array();
			var list = $("input[name='RowCheck']");
			for (var i = 0; i < list.length; i++) {
				if (list[i].checked) {
					valueArr.push(list[i].value);
				}
			}
			if (valueArr.length == 0) {
				alert("선택된 상품이 없습니다.")
			} else {
				var chk = confirm("정말 삭제하시겠습니까?");
				$.ajax({
					url : url, // 전송 url
					type : 'POST',
					traditional : true,
					data : {
						valueArr : valueArr
					// 보내고자 하는 date 변수 
					},
					success : function(data) {
						if (data = 1) {
							alert("삭제 되었습니다.");
							location.replace("prodList") // 상품 리스트페이지 새로고침
						} else {
							alert("삭제 실패")
						}
					}
				})
			}

		}
	</script>

</body>

</html>




























