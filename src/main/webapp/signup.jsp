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
<link rel="stylesheet" href="css/signup.css">

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
				<li class="nav-item"><a class="nav-link" onclick="location.href='login.jsp'">로그인</a></li>
				<li class="nav-item"><a class="nav-link" onclick="location.href='signup.jsp'">회원가입</a></li>
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

	<section>
		<table width="500">
			<tr height="80">
				<td align="center"><b>회원가입</b></td>
			</tr>
		</table>
		<center>
			<form action="register.php" method="post" name="twin">
				<table width="600" height="400"
					style="border-collapse: collapse; font-size: 9pt;">
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">회원 ID</td>
						<td><input type="text" name="wUserID" size="40" />&nbsp;<a
							href="javascript:id_check()">[ID 중복 검사]</a></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">비밀번호</td>
						<td><input type="password" name="wUserPW" id="pw"
							onchange="isSame()" size="40" /></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">비밀번호 확인</td>
						<td><input type="password" name="wUserPWConfirm" id="pwCheck"
							onchange="isSame()" size="40"/>&nbsp;&nbsp;<span id="same"></span></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">이 름</td>
						<td><input type="text" name="wUserName" size="40"/></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">성 별</td>
						<td>남 성<input type="checkBox" name="wUserGender" value="1" size="40"
							checked />&nbsp;여 성<input type="checkBox" name="wUserGender"
							value="2" />
						</td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">휴대전화</td>
						<td><input type="tel" name="wUserCellPhone" size="40" /></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr class="register" height="10">
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">이메일</td>
						<td><input type="email" name="wUserEmail" size="40"/></td>
					</tr>
					<tr height="7">
						<td colspan="3"><hr /></td>
					</tr>
					<tr>
						<td width="5%" align="center" style="color: red">*</td>
						<td width="15%">주 소</td>
						<td><input type="text" size="10" name="wPostCode"
							id="postcode" readonly="readonly" onclick="DaumPostcode()">
							<input type="button" onclick="DaumPostcode()" value="우편번호 검색"><br>
							<br /> <input type="text" size="30" name="wRoadAddress"
							id="roadAddress" readonly="readonly" onclick="DaumPostcode()">
							<input type="text" size="30" name="wJibunAddress"
							id="jibunAddress" readonly="readonly" onclick="DaumPostcode()">
							<br /> <span id="guide" style="color: #999; font-size: 10px;"></span>
							<br /> <input type="text" name="wRestAddress" size="70" /></td>
					</tr>

				</table>
				<br>
				<div>
					<input type="button" onclick="DaumPostcode()" value="취소">
					<input type="button" onclick="DaumPostcode()" value="회원가입">
				</div>
			</form>
		</center>
			<br><br>

	</section>
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