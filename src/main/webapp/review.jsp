<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="popper/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<title>Kit.</title>


<!-- 상단 로그인 회원가입 바 -->
</head>
<body>
	<div
		class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end">
		<div class="navbar-nav" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					onclick="location.href='login.jsp'">로그인</a></li>
				<li class="nav-item"><a class="nav-link"
					onclick="location.href='signup.jsp'">회원가입</a></li>
			</ul>
		</div>
	</div>


	<!-- 상단 로고 메뉴 바 -->
	<!-- Navigation -->

	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-center sticky-top">
		<a class="navbar-brand" href="#"><img src="img/Kit2_size.png"
			class="d-inline-block align-top" alt=""></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="btn1 nav-link" href="">Kit.소개</a></li>
				<li class="nav-item"><a class="btn1 nav-link" href="">Kit.메뉴</a></li>
				<li class="nav-item"><a class="btn1 nav-link" href="">리뷰</a></li>
				<li class="nav-item"><a class="btn1 nav-link" href="">이벤트</a></li>
				<li class="nav-item"><a class="btn1 nav-link" href="">MyKit.</a></li>
			</ul>
		</div>
	</nav>

	<h1
		style="margin-top: 50px; margin-left: 50px; margin-bottom: 10px; font-weight: bolder;">리뷰</h1>
	<hr align="center" style="border: solid 2px #e0e0e0; width: 95%;">

	<table class="col-sm-8" style="margin-left: 450px;">
		<tr>
			<td><a href="review2.jsp" target="_blank"> <img alt="리뷰1" src="img/7.PNG" /></a></td>
			<td><a href="review3.jsp" target="_blank"> <img alt="리뷰2" src="img/8.PNG" /></a></td>
		<tr>
	</table>
	<h4
		style="margin-top: 50px; margin-left: 50px; margin-bottom: 10px; font-weight: bolder;">리뷰
		3,378건</h4>
	<hr align="center" style="border: solid 2px #e0e0e0; width: 95%;">

	<h5 align="right" style="margin-right: 50px;">2021.7.19</h5>
	<h4 style="margin-left: 50px; font-weight: bolder;">비건식 영양 밀키트</h4>
	<img style="margin-left: 50px;" src="img/3.PNG" />
	<a>&nbsp;jinwo***</a>
	<a href="review2.jsp" target="_blank"> <img
		style="margin-left: 50px;" src="img/9.PNG" /></a>

	<hr align="center" style="border: solid 1px #e0e0e0; width: 95%;">
	<h5 align="right" style="margin-right: 50px;">2021.7.19</h5>
	<h4 style="margin-left: 50px; font-weight: bolder;">육즙팡팡 고기밀키트</h4>
	<img style="margin-left: 50px;" src="img/4.PNG" />
	<a>&nbsp;sun***</a>
	<a href="review3.jsp" target="_blank"> <img
		style="margin-left: 50px;" src="img/10.PNG" /></a>

	<hr align="center" style="border: solid 1px #e0e0e0; width: 95%;">
	<h5 align="right" style="margin-right: 50px;">2021.7.19</h5>
	<h4 style="margin-left: 50px; font-weight: bolder;">비건식 영양 밀키트</h4>
	<img style="margin-left: 50px;" src="img/3.PNG" />
	<a>&nbsp;hong***</a>
	<a href="review2.jsp" target="_blank"> <img
		style="margin-left: 50px;" src="img/9.PNG" /></a>

	<hr align="center" style="border: solid 1px #e0e0e0; width: 95%;">
	<h5 align="right" style="margin-right: 50px;">2021.7.19</h5>
	<h4 style="margin-left: 50px; font-weight: bolder;">육즙팡팡 고기밀키트</h4>
	<img style="margin-left: 50px;" src="img/4.PNG" />
	<a>&nbsp;hyeong***</a>
	<a href="review3.jsp" target="_blank"> <img
		style="margin-left: 50px;" src="img/10.PNG" /></a>

	<!-- footer 배너인데 우선 이렇게 두고 나중에 크기랑 이런거 손보겠습니다. -->
	<footer>
		<div class="jumbotron text-center jumbotron-fluid bg-secondary ">
			<div class="foo_div"></div>
			<img src="img/Kit2_size.png" />
			<div class="foo_div1">
				<span>(주)Kit.</span> <span> | </span> <span>대표 : 선진정형 </span> <span>
					| </span> <span>사업자 등록 번호 : 000-00-0000</span> <span> | </span>
				<p>주소 : 서울 종로구 종로 69 서울YMCA 7층.</p>
				<p>Kit.</p>
			</div>
		</div>
	</footer>




</body>
</html>