<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
	<div class="container" style="margin-top:3%;">
	<form action="/admin/itemupdate" method="post"> 
	<h4 style="padding-bottom:1%;">
		상품일괄수정
	<input type="submit" class="btn btn-success" style="float:right; margin: 1%;" value="완료">
	</h4>
	<table class="table">
		<thead>
			<tr>
				<th>구분</th>
				<th>이름</th>
				<th>가격</th>
				<th>재고수량</th>
				<th>설명</th>
				<th>날짜</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="tmp" items="${list}">
			<input type="text" name="no[]" value="${tmp.itemno}">
			<tr>

				<td>${tmp.itemno}</td>
				<td><input type="text" name="name[]" value="${tmp.itemname}"></td>
				<td><input type="text" name="price[]" value="${tmp.itemprice}"></td>
				<td><input type="text" name="qty[]" value="${tmp.itemqty}"></td>
				<td><input type="text" name="des[]" value="${tmp.itemdes}"></td>
				<td>${tmp.itemdate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	</form>
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
	    <c:forEach var="i" begin="1" end="${cnt}" step="1">
 	    <li class="page-item"><a class="page-link" href="/item/list?page=${i}">${i}</a></li>
	    </c:forEach>
	    <li class="page-item"><a class="page-link" href="#">Next</a></li>
	  </ul>
	</nav>
</div>
</body>
</html>