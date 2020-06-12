<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
<title>관리자</title>
</head>
<body>
	<div class="container">
		<a href="/admin/item">물품목록관리</a>
		<a href="/admin/iteminsert">물품일괄등록</a>
		<a href="/admin/member">회원관리</a>
		<a href="/admin/board">게시물관리</a>
	</div>
</body>
</html>