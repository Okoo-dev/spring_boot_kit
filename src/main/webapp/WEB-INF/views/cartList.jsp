<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		
		<tr>
         	<td>번호</td>
        	 <td>상품명</td>
        	 <td>가격</td>
        	 <td>수량</td>
       		 <td>금액</td>
    	<tr/>
   	 <c:forEach var="vo" items="${list}">
   	 <c:set var="i" value="${i+1}"/>
        <tr>
         	 <td>${i}</td>
           	 <td>${vo.bname}</td>
             <td>
              	 <c:forEach begin="1" end="${vo.bindent}">-</c:forEach>
             	  <a href="content_view?bid=${vo.bid}">${vo.btitle}</a></td>
          	  <td>${vo.bdate}</td>
           	 <td>${vo.bhit}</td>
        <tr/>
     </c:forEach>
     	 <tr>
        	 <td colspan="5"> <a href="write_view">글작성</a> </td>
     	 </tr>
     	 
   </table>
</body>
</html>