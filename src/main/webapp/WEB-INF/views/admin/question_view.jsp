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
					<i class="fa fa-angle-right"></i> 1:1문의
				</h3>
				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<i class="fa fa-angle-right"></i>
							<form class="form-horizontal style-form">
								<input type="hidden" name="brdId" value="${question_view.brdId}">

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">글 제목</label> <label
										class="col-sm-2 col-sm-2 control-label">${question_view.brdTitle}</label>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">글 내용</label> <label
										class="col-sm-2 col-sm-2 control-label">${question_view.brdContent}</label>
								</div>

								<div class="container">
									<label for="content">답글</label>
									<form name="commentInsertForm">
										<div class="input-group">
											<input type="hidden" id="brdId" name="brdId"
												value="${question_view.brdId}"> <input type="text"
												id="replyContent" class="form-control" name="replyContent"
												placeholder="내용을 입력하세요."> <span
												class="input-group-btn">

												<button class="btn btn-default" type="button"
													name="commentInsertBtn">등록</button>
											</span>
										</div>
									</form>
								</div>

								<div class="container">
									<div class="commentList"></div>
								</div>



								<table>
									<tr>
										<td colspan="2"><a href="/admin/questionList"><button
													type="button" class="btn btn-round btn-info">목록보기</button></a>
											&nbsp;&nbsp;<a id="a-delete"
											href="${pageContext.request.contextPath}questionDelete?brdId=${question_view.brdId}">
												<button type="button" class="btn btn-round btn-warning">삭제</button>
										</a></td>
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

	<script>
		var brdId = '${question_view.brdId}'; //게시글 번호

		//댓글 목록 
		function commentList() {
			$
					.ajax({
						url : '/admin/replyList',
						type : 'get',
						data : {
							'brdId' : brdId
						},
						success : function(data) {
							var a = '';
							$
									.each(
											data,
											function(key, value) {
												a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
												a += '<div class="commentInfo'+value.replyId+'">'
														+ '답글번호 : '
														+ value.replyId
														+ ' / 작성자 : '
														+ value.userId;
												a += '<a onclick="commentUpdate('
														+ value.replyId
														+ ',\''
														+ value.replyContent
														+ '\');"> 수정 </a>';
												a += '<a onclick="commentDelete('
														+ value.replyId
														+ ');"> 삭제 </a> </div>';
												a += '<div class="commentContent'+value.replyId+'"> <p> 내용 : '
														+ value.replyContent
														+ '</p>';
												a += '</div></div>';
											});

							$(".commentList").html(a);
						}
					});
		}
		
		$('[name=commentInsertBtn]').click(function() { //댓글 등록 버튼 클릭시 

			var data = {
				replyContent : $("#replyContent").val(),
				boardId : $("#brdId").val()
			}

			console.log(data);

			$.ajax({
				url : '/admin/replyInsert',
				type : 'POST',
				data : data,
				success : function(data) {
					if (data == 1) {
						commentList(); //댓글 작성 후 댓글 목록 reload
						$('[name=replyContent]').val('');
					}
				}
			});

		});
		
		//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
		function commentUpdate(replyId, replyContent) {
			var a = '';

			a += '<div class="input-group">';
			a += '<input type="text" class="form-control" name="content_'+replyId+'" value="'+replyContent+'"/>';
			a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('
					+ replyId + ');">수정</button> </span>';
			a += '</div>';

			$('.commentContent' + replyId).html(a);

		}
		
		//댓글 수정
		function commentUpdateProc(replyId) {
			var updateReply = $('[name=content_'+replyId+']').val()
			console.log(updateReply);
			
			$.ajax({
				url : '/admin/replyUpdate',
				type : 'post',
				data : {'replyContent' : updateReply, 'replyId' : replyId},
				success : function(data) {
					if (data == 1)
						commentList(brdId); //댓글 수정후 목록 출력 
				}
			});
		}

		//댓글 삭제 
		function commentDelete(replyId) {
			$.ajax({
				url : '/admin/replyDelete/' + replyId,
				type : 'post',
				success : function(data) {
					if (data == 1)
						commentList(brdId); //댓글 삭제후 목록 출력 
				}
			});
		}

		$(document).ready(function() {
			commentList(); //페이지 로딩시 댓글 목록 출력 
		});
	</script>








</body>

</html>
