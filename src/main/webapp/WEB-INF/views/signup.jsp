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
	
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/style.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/myMain.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/kit/css/all.css">
		
				
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="${pageContext.request.contextPath}/resources/kit/js/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/kit/popper/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/kit/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/kit/js/all.js"></script>
		
		
	 	
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/";
			})
			
			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
				var idChkVal = $("#idChk").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}
			});
		})
		
		function fn_idChk(){
			$.ajax({
				url : "/member/idChk",
				type : "post",
				dataType : "json",
				data : {"userId" : $("#userId").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				}
			})
		}
	</script>
	
<div
		class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end">
		<div class="navbar-nav" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<sec:authorize access="isAnonymous()">
				<!-- 로그인 하지 않은 사용자에게 보이도록  -->
					<li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
				</sec:authorize>
				<!-- 로그인한 사용자에게 보이도록  -->
				<sec:authorize access="isAuthenticated()">
    				<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
				</sec:authorize>
				</ul>
		</div>
	</div>
	
<!-- 상단 로고 메뉴 바 -->
	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-center ">
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
	
	
	<body>
	
	
	
	
		<section id="container" class="container">
		
			<div class="col-sm-2"></div>   <!-- 왼쪽 공백 -->
			<div class="col-sm-6">      <!-- 입력 창 -->
			<div class="row"> <!-- 정렬 -->
			   <div class="bg-white py-3 px-0"></div>  <!-- 위쪽 공백 -->
			   
			   
  				 <div class="container">
    				  <h1 class="text-left font-weight-bold">회원가입</h1>
    				  <hr class="underline ">
 			 	 </div>
			
			
			<form action="/member/register" method="post" id="regForm" >
				<div class="container">  <!-- 폼 안쪽 정렬  -->
					<div class="form-group has-feedback col">
						<label class="control-label font-weight-bold" style="font-size:0.9em;" for="userId">아이디</label>
						<input class="form-control" type="text" id="userId" name="userId" />
						<button class="idChk " type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>
					</div>
				
				<div class="form-group has-feedback col">
					<label class="control-label  font-weight-bold" style="font-size:0.9em;" for="userPass">패스워드</label>
					<input class="form-control" type="password" id="userPass" name="userPass" />
				</div>
				<div class="form-group has-feedback col">
					<label class="control-label  font-weight-bold" style="font-size:0.9em;" for="userName">성명</label>
					<input class="form-control" type="text" id="userName" name="userName" />
				</div>
			  </div> <!-- 정렬 끝 -->
			</form>
			 <div class="container text-align-center">
			 <div class="row">
				<div class="form-group has-feedback ">
					<button class="btn btn-success" type="button" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			 </div>	
			</div> 
			
			
			
				</div> <!-- 폼 안쪽 정렬 끝 -->
			</div>   <!-- 입력 창 끝 -->
				<div class="col-sm-2"></div>  <!-- 오른쪽 공백--> 
				
		</section>
		
		
		
		
	<!-- footer 배너인데 우선 이렇게 두고 나중에 크기랑 이런거 손보겠습니다. -->
	<footer>
		<div class="jumbotron text-center jumbotron-fluid bg-secondary mt-5">
			<div class="foo_div"></div>
			<img src="${pageContext.request.contextPath}/resources/kit/img/Kit2_size.png" />
			<div class="foo_div1">
				<span>(주)Kit.</span> <span> | </span> <span>대표 : 선진정형 </span> <span>
					| </span> <span>사업자 등록 번호 : 000-00-0000</span> <span> | </span>
				<p>주소 : 서울 종로구 종로 69 서울YMCA 7층.</p>
				<p>Kit.</p>
				<img src="${pageContext.request.contextPath}/resources/kit/img/kakaotalk.png">
				<img src="${pageContext.request.contextPath}/resources/kit/img/google+.png">
				<img src="${pageContext.request.contextPath}/resources/kit/img/naver.png">
			</div>
		</div>
	</footer>	
		
		
		
		
		
		
	</body>
	
</html>