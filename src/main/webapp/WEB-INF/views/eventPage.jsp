<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- security 사용한 tag 참조 위한 부분  -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/myMain.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/all.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/eventstyle.css">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/resources/kit/js/jquery-3.2.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/kit/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/kit/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/kit/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<title>Kit.</title>


<!-- 상단 로그인 회원가입 바 -->
</head>
<div
		class="navbar navbar-expand-sm justify-content-end" id="nav1">
		<div class="navbar-nav" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<sec:authorize access="isAnonymous()">
				<!-- 로그인 하지 않은 사용자에게 보이도록  -->
					<li class="nav-item"><a class="nav-link" href="/login" id="navtop1">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="#" id="navtop1">회원가입</a></li>
				</sec:authorize>
				<!-- 로그인한 사용자에게 보이도록  -->
				<sec:authorize access="isAuthenticated()">
    				<li class="nav-item"><a class="nav-link" href="/logout" id="navtop1">로그아웃</a></li>
				</sec:authorize>
				</ul>
		</div>
	</div>



<!-- 상단 로고 메뉴 바 -->
	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg justify-content-center" id="nav2">
		<a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/resources/kit/img/Kit2_size.png"
			class="d-inline-block align-top" alt="로고"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto" id="ul1">
			<li class="nav-item"><a class="btn1 nav-link" href="">Kit.소개</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="">Kit.메뉴</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="">리뷰</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="">이벤트</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="">MyKit.</a></li>
		</ul>
		<ul class="navbar-nav ml-auto mr-5" >
			<li class="nav-item fa-2x" OnClick="location.href ='#'" style="cursor:pointer;">
			  <span class="fa-layers fa-fw" style="background:white">
    				<i class="fas fa-shopping-cart"></i>
    			<span class="fa-layers-counter fa-layers-top-right" id="cartbadge" > 1</span>
  			  </span>
  			   <p id="cart" >장바구니</p>
		
			</li>
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
         <li id="topmenu1" class="ing"><a href="#">진행중</a></li>
         
         <li id="topmenu1" class="ing ml-3"><a href="#">당첨자 발표</a></li>
      </ul>
      


<!--card-->

<div class="card-deck">

<c:forEach items="${eventList}" var="vo">
 
 	<div class="col-sm-4 my-4" OnClick="location.href ='#'" style="cursor:pointer;">
		<div class="card border-0">
  			<img src = "${pageContext.request.contextPath}/resources/kit/img/event1.jpg" class="card-img-top"  alt= "이벤트 사진">
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
		<div class="jumbotron jumbotron-fluid " id="bot1">
			<div class="row">
			<div class="container col-1"></div>
			<div class="container col-2">
			  <img src="${pageContext.request.contextPath}/resources/kit/img/KitWhite.png" />
			  </div>
			<div class="container col-9">
				<div class="row mb-4" style="line-height: 40px;">
      					<div  class="text-center col-2" id="bot2" >
      							<span class="font-weight-bold" style="font-size: 0.8em; color: white;">이용약관</span><br>
						</div>
      					<div  class="text-center col-3" id="bot2" >
      							<span class="font-weight-bold" style="font-size: 0.8em; color: white;">개인정보처리 방침</span><br>
						</div>
      					<div  class="text-center col-2" id="bot2">
      							<span class="font-weight-bold" style="font-size: 0.8em; color: white;">법적고지</span><br>
						</div>
						<div  class="text-center col-3" style="line-height: 10px;">
								<span class="font-weight-bold " style="font-size: 0.8em; color: white;">사업자정보 확인</span><br>
						</div>	
						<div class="container col-2"></div>
      	     	</div>
      	     	<div class="container ml-2 mr-0 mt-3 ">
      	     		<span id="bot3"> Kit.(주)</span>
      	     		<span id="bot3"> 대표이사: 송진우, 홍정호, 김선규</span>
      	     		<span id="bot3"> 사업자등록번호: 103-03-290820</span> <br>
      	     		<span id="bot3"> 주소 : 서울특별시 종로구 종로 69(종로2가) 7층 Kit. </span> 
      	     		<span id="bot3"> 통신판매업신고 중구 제0000호 </span>  <br>
      	     		<span id="bot3"> 이메일: kit@kit.com </span> 
      	     		<span id="bot3"> 호스팅제공자: 비트캠프7층어딘가 </span> <br>
      	     		<span id="bot3"> ⓒKit. CORP. ALL RIGHTS RESERVERD. </span> 
      	     	</div>
			</div>
			
			
			
			</div>
		</div>
	</footer>
<script>
$('#cartbadge').text('0');
</script>
</body>
</html>