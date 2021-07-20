<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 
  이벤트 페이지 과제 : 이벤트 게시글 이미지 첨부파일 어떻게 가져올지, 이벤트 기간 DB 어떻게 할지.
 -->
<!doctype html>
<html lang="ko">
<head>



<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/kit/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/kit/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/kit/css/eventstyle.css">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="popper/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<title>Kit.</title>


<!-- 상단 로그인 회원가입 바 -->
</head>
<div
		class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end">
		<div class="navbar-nav" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
			</ul>
		</div>
	</div>


<!-- 상단 로고 메뉴 바 -->
	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-center sticky-top">
		<a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/resource/kit/img/Kit2_size.png"
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

<body>
	

	
	<!-- 컨텐츠 넣으면됨 -->
	
	
      <div class="bg-white py-3 px-0"></div>
   <div class="container">
     
      <h1 class="text-left font-weight-bold">이벤트</h1>
      <hr class="underline">
      
      <ul class="nav mb-5" >
         <li id="topmenu1"><a href="#">진행중</a></li>
         <li id="topmenu1"><a href="#">당첨자 발표</a></li>
      </ul>
      


<!--card-->

<div class="card-deck">

<c:forEach items="${eventList}" var="vo">
 
 	<div class="col-sm-4 my-4" OnClick="location.href ='#'" style="cursor:pointer;">
		<div class="card border-0">
  			<img src = "${pageContext.request.contextPath}/resource/kit/img/event1.jpg" class="card-img-top"  alt= "이벤트 사진">
    			<div class="card-body px-0">
    	 			 <p class="card-text"><kbd>EVENT</kbd> <kbd class="red">D-3</kbd>   2021.07.01~2021.09.30</p>
    	 			 <h6 class="card-text font-weight-bold">${vo.brdTitle }</h6>
   				</div>
   		</div>
    </div>
 
 </c:forEach>
 
 
 
 	
    
 
 
 	
    
</div>    
    
 




        </div>

	<!-- 컨텐츠 넣으면됨 --><!-- 컨텐츠 넣으면됨 --><!-- 컨텐츠 넣으면됨 --><!-- 컨텐츠 넣으면됨 --><!-- 컨텐츠 넣으면됨 -->


	<!-- footer 배너인데 우선 이렇게 두고 나중에 크기랑 이런거 손보겠습니다. -->
	<footer>
		<div class="jumbotron text-center jumbotron-fluid bg-secondary mt-5">
			<div class="foo_div"></div>
			<img src="img/Kit2_size.png" />
			<div class="foo_div1">
				<span>(주)Kit.</span> <span> | </span> <span>대표 : 선진정형 </span> <span>
					| </span> <span>사업자 등록 번호 : 000-00-0000</span> <span> | </span>
				<p>주소 : 서울 종로구 종로 69 서울YMCA 7층.</p>
				<p>Kit.</p>
				<img src="img/kakaotalk.png">
				<img src="img/google+.png">
				<img src="img/naver.png">
			</div>
		</div>
	</footer>


</body>
</html>