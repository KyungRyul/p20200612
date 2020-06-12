<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<div class="container" style="margin-top:3%;">
	<h1>글 작성</h1>
	<form action="/board/insert" method="post" encType="multipart/form-data" id="form1">
	<table class="table table-bordered" >
	     <tr>
	         <th>제목: </th>
	         <td><input type="text" placeholder="제목을 입력하세요. " name="brd_title" class="form-control"/></td>
	     </tr>
	     <tr>
	         <th>내용: </th>
	         <td><textarea cols="10" placeholder="내용을 입력하세요. " name="brd_content" class="form-control"></textarea></td>
	     </tr>
	     <tr>
	         <th>첨부파일: </th>
	         <td><input type="file" placeholder="파일을 선택하세요. " name="imgs" class="form-control"/></td>
	     </tr>
	     <tr>
	         <th>작성자  </th>
	         <td>
	         	<input type="text" placeholder="작성자를 입력하세요" name="brd_id" class="form-control" value="${userid}" readonly/>
         	</td>
	     </tr>
	     <tr>
	         <td colspan="2"> 
	         	<input type="submit" class="btn btn-default" value="등록">
	             <a class="btn btn-default" type="reset" onclick="javascript:document.getElementById('form1').reset()"> reset </a>
	             <a class="btn btn-default" onclick="javascript:location.href='list'">글 목록으로</a> -->
	         </td>
	     </tr>
      
    </tbody>
	</table>
  </form>
</div>
</body>
</html>