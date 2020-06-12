<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
<title>물품등록</title>
</head>
<body>
	<div class="container">
		<form action="/admin/iteminsert" method="post">
	
		<table class="table table-bordered" >
		<c:forEach var="i" begin="1" end="5" step="1">
		<tr>
	     <td>${i}</td>
	     </tr>
	     <tr>
	         <th>물품명</th>
	         <td><input type="text" placeholder="물품명"  class="form-control" name="name[]" value="사과"/>
	        </td>
	     </tr>
	     <tr>
	         <th>가격</th>
	         <td><input type="text" placeholder="가격 " class="form-control" name="price[]" value="5000"/>
	        </td>
	     </tr>
	     <tr>
	         <th>수량  </th>
	         <td>
	         	<input type="text" placeholder="수량" class="form-control" name="qty[]" value="20"/>
         	</td>
	     </tr>
	     <tr>
	         <th>물품설명  </th>
	         <td>
	         	<input type="text" placeholder="물품설명" class="form-control" name="content[]" value="맛잇음"/>
         	</td>
	     </tr>
	     
      	</c:forEach>
    </tbody>
	</table>
	<input type="submit" class="btn btn-success" value="등록">
	</form>
	</div>
</body>
</html>