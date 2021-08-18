<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- security 사용한 tag 참조 위한 부분  -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
					<li class="nav-item"><a class="nav-link" href="/signin" id="navtop1">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/signup" id="navtop1">회원가입</a></li>
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
		<a class="navbar-brand" href="/index"><img src="${pageContext.request.contextPath}/resources/kit/img/Kit2_size.png"
			class="d-inline-block align-top" alt="로고"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto" id="ul1">
			<li class="nav-item"><a class="btn1 nav-link" href="">Kit.소개</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="/menu">Kit.메뉴</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="">리뷰</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="/event">이벤트</a></li>
			<li class="nav-item"><a class="btn1 nav-link" href="/mymain">MyKit.</a></li>
		</ul>
		<ul class="navbar-nav ml-auto mr-5" >
			<li class="nav-item fa-2x" OnClick="location.href ='/cart'" style="cursor:pointer;">
			  <span class="fa-layers fa-fw" style="background:white">
    				<i class="fas fa-shopping-cart"></i>
    			<span class="fa-layers-counter fa-layers-top-right" id="cartbadge" > ${cartCount}</span>
  			  </span>
  			   <p id="cart" >장바구니</p>
		
			</li>
		</ul>
	</div>
</nav>

<body>
	

	
	<!-- 컨텐츠 넣으면됨 -->
	<div class="container">
  <div class="row">
	
	
	<div class="col-md-3">
<!-- 사이드 바 메뉴-->
<div class="container">
 <h1 class="text-left font-weight-bold my-4">MyKit</h1>
 </div>
  <!-- 패널 타이틀1 -->
<div class="panel panel-info">
    <!-- 사이드바 메뉴목록1 -->
    <ul class="list-group">
      <li class="list-group-item border-0 mb-0 pb-0"><h5 class= "font-weight-bold ">나의 주문정보</h5></li>
      <li class="list-group-item border-0 py-1"><a href="/myorder">주문/배송 조회</a></li>
      <li class="list-group-item border-0 py-1"><a href="/myaddress">배송지 관리</a></li>
      <li class="list-group-item border-0 py-1"><a href="/myaccount">환불계좌 관리</a></li>
    </ul>
</div>


  <!-- 패널 타이틀1 -->
<div class="panel panel-info">
    <!-- 사이드바 메뉴목록1 -->
    <ul class="list-group">
      <li class="list-group-item border-0 mt-3 mb-0 pb-0"><h5 class= "font-weight-bold ">나의 혜택</h5></li>
      <li class="list-group-item border-0 py-1"><a href="/mycoupon">쿠폰</a></li>
      <li class="list-group-item border-0 py-1"><a href="/mypoint">포인트</a></li>
    </ul>
</div>


  <!-- 패널 타이틀1 -->
<div class="panel panel-info">
    <!-- 사이드바 메뉴목록1 -->
    <ul class="list-group">
      <li class="list-group-item border-0 mt-3 mb-0 pb-0"><h5 class= "font-weight-bold ">나의 활동</h5></li>
      <li class="list-group-item border-0 py-1"><a href="#">나의 리뷰</a></li>
      <li class="list-group-item border-0 py-1"><a href="#">쇼핑찜</a></li>
      <li class="list-group-item border-0 py-1"><a href="#">1:1문의</a></li>
    </ul>
</div>


  <!-- 패널 타이틀1 -->
<div class="panel panel-info">
    <!-- 사이드바 메뉴목록1 -->
    <ul class="list-group">
      <li class="list-group-item border-0 mt-3 mb-0 pb-0"><h5 class= "font-weight-bold ">나의 정보</h5></li>
      <li class="list-group-item border-0 py-1"><a href="/tomodify">개인정보 변경</a></li>
      <li class="list-group-item border-0 py-1"><a href="/toresign">회원탈퇴</a></li>
    </ul>
</div>


</div>



<!-- 9단길이 -->
  <div class="col-md-9">
  
  
  <!-- 심플카드  -->
  	     
      <div class="container my-5">
      	<div class="row" style=" background: linear-gradient(to right, #ccff33, #86b300); line-height: 70px;">
      		<div  class="col-lg-2 text-nowrap border-0 text-left pl-3" ><span class="font-weight-bold" style="font-size:1.2em;"> ${user.userName}</span></div>
			<div  class="offset-3 col-lg-5 text-nowrap border-0 text-right small "><i class="fas fa-map-marker-alt"></i><span> ${user.userAddress1} ${user.userAddress2} ${user.userAddress3}</span></div>
      	</div>
      	<div class="row" style="border:2px solid; border-top: none; border-color: #f2f2f2; background: white; line-height: 70px;">
      		<div  class="text-center col-7 my-3" style="border-right:2px solid;  border-color: #f2f2f2; line-height: 40px;" >
      			<span class="font-weight-bold" style="font-size: 1.1em;">포인트</span><br>
      			<span class="font-weight-bold" OnClick="location.href ='/mypoint'" style="font-size: 2em; cursor:pointer;"><fmt:formatNumber value="${point.point}" pattern="#,###"/>P</span>
			</div>
			<div  class="text-center col-5 my-3" style="line-height: 40px;">
				<span class="font-weight-bold " style="font-size: 1.1em;">보유쿠폰</span><br>
				<span class="font-weight-bold " OnClick="location.href ='/mycoupon'" style="font-size: 2em; cursor:pointer;"> ${couponCount}장</span>
			</div>	
      	</div>
      </div>
      
      <!-- 주문/조회  -->
      <table class="table table-bordered table-sm mt-4 pb-1 border-0">
			<thead class="thead-no">
				<tr>
					<th  class="text-nowrap border-0 text-left "><h5 class="font-weight-bold"> 주문/배송조회</h5></th>
					<th  class="text-nowrap border-0 text-right small "><a href="/myorder">더보기 ></a></th>
				</tr>
			</thead>
  		</table>
  		
  	
  	
  	<!-- card deck 시작 -->
  	<div class="card-group ml-4 my-3">
 
 	<div class="col-sm-2 mx-0 px-0" OnClick="location.href ='/myorder'" style="cursor:pointer;">
		<div class="card border-0 ">
    			<div class="card-body px-4 my-4 ">
    				<div class="fa-layers fa-fw my-2" style="background:white">
    			<i class="fas fa-circle fa-6x" style="color:#f2f2f2"></i>
   				 <i class="fa-inverse far fa-credit-card fa-3x" data-fa-transform="shrink-4 right-7" style="color:#8c8c8c"></i>
  					</div>
    			</div>
   		
   				<div class="card-footer bg-white px-1 py-0 text-center border-0 ">
   					<h6 class="card-text font-weight-bold ">주문/결제</h6>
   				</div>
   			</div>
   		</div>
   		
 	<div class="col-sm-1 mx-0 px-0 text-center" >
			<div class="card border-0 ">
    			<div class="card-body px-0 mx-0 mb-5 "> <h1 class="display-4">></h1>
    			</div>
   			</div>
   	</div>
   		
 
 	<div class="col-sm-2 " OnClick="location.href ='/myorder'" style="cursor:pointer;">
		<div class="card border-0 ">
    			<div class="card-body px-2 my-4 ">
    				<div class="fa-layers fa-fw my-2" style="background:white">
    			<i class="fas fa-circle fa-6x" style="color:#f2f2f2"></i>
   				 <i class="fa-inverse fas fa-dolly-flatbed fa-3x" data-fa-transform="shrink-4 right-6 down-1" style="color:#8c8c8c"></i>
  					</div>
    			</div>

   				<div class="card-footer bg-white px-1 py-0 text-center border-0 ">
   					<h6 class="card-text font-weight-bold ">&nbsp;&nbsp; 배송준비</h6>
   				</div>
   			</div>
   		</div>
   		
   <div class="col-sm-1 mx-0 px-0 text-center" >
			<div class="card border-0 ">
    			<div class="card-body px-0 mx-0 mb-5 "> <h1 class="display-4">></h1>
    			</div>
   			</div>
   	</div>	
   		
   		
 
 	<div class="col-sm-2 " OnClick="location.href ='/myorder'" style="cursor:pointer;">
		<div class="card border-0 ">
    			<div class="card-body px-2 my-4 ">
    				<div class="fa-layers fa-fw my-2" style="background:white">
    			<i class="fas fa-circle fa-6x" style="color:#f2f2f2"></i>
   				 <i class="fa-inverse fas fa-truck fa-3x" data-fa-transform="shrink-4 right-7 " style="color:#8c8c8c"></i>
  					</div>
    			</div>
   		
   				<div class="card-footer bg-white px-1 py-0 text-center border-0 ">
   					<h6 class="card-text font-weight-bold ">&nbsp;&nbsp; 배송중</h6>
   				</div>
   		 </div>
 	</div>
   	
   	<div class="col-sm-1 mx-0 px-0 text-center" >
			<div class="card border-0 ">
    			<div class="card-body px-0 mx-0 mb-5 "> <h1 class="display-4">></h1>
    			</div>
   			</div>
   	</div>
   		
 
 	<div class="col-sm-2 " OnClick="location.href ='/myorder'" style="cursor:pointer;">
		<div class="card border-0 ">
    			<div class="card-body px-2 my-4 ">
    				<div class="fa-layers fa-fw my-2" style="background:white">
    						<i class="fas fa-circle fa-6x" style="color:#f2f2f2"></i>
   							<i class="fa-inverse fas fa-user fa-3x" data-fa-transform="shrink-4 right-9" style="color:#8c8c8c"></i>
  					</div>
    			</div>
   		
   				<div class="card-footer bg-white px-1 py-0 text-center border-0 ">
   					<h6 class="card-text font-weight-bold ">&nbsp;&nbsp; 배송완료</h6>
				</div>
   		 </div>
 	</div>
   	
 
   		
   		
    </div>
 
 	<!-- card deck  끝 -->
 	
 	
 <!-- 
 
  		쇼핑찜 
      <table class="table table-bordered table-sm mt-4 pb-1 border-0">
			<thead class="thead-no">
				<tr>
					<th  class="text-nowrap border-0 text-left "><h5 class="font-weight-bold"> 쇼핑찜</h5></th>
					<th  class="text-nowrap border-0 text-right small "><a href="#">더보기 ></a></th>
				</tr>
			</thead>
  		</table>
  		 -->
 
 
 	
    
</div> 
  <!-- 9단길이 끝-->		
  		
  		
  
  
  
 
  	
  	

  			
  			
  		</div>
    </div>
<!-- 전체 컨테이너 끝 -->


  	

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


</body>

<script>
	var result = '${result}';
	if(result === 'registerOK'){
		alert('등록이 완료되었습니다.');
	}
</script>

</html>