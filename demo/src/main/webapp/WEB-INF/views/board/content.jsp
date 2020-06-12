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
	<h1>${content.brd_title}</h1>
	<form action="/board/insert" method="post" encType="multipart/form-data">
	<table class="table table-bordered" >
	     <tr>
	         <th style="width:20%;">내용: </th>
	         <td>${content.brd_content}</td>
	     </tr>
	     <tr>
	         <th>첨부파일: </th>
	         <td>이미지</td>
	     </tr>
	     <tr>
	         <th>작성자  </th>
	         <td>
	         	${content.brd_id}
         	</td>
	     </tr>
	     <tr>
	         <th>조회수  </th>
	         <td>
	         	${content.brd_hit}
         	</td>
	     </tr>
	     <tr>
	         <th>날짜  </th>
	         <td>
	         	${content.brd_date}
         	</td>
	     </tr>
	      <tr>
	         <th>이미지  </th>
	         <td>
	         	<img src="/board/getimg?no=${content.brd_no
	         	 }" width="100px" height="100px" /><br />
         	</td>
	     </tr>
	     <tr>
	         <td colspan="2">
	             <a class="btn btn-default" onclick="javascript:location.href='list'">글 목록으로</a> -->
	         </td>
	     </tr>
      
    </tbody>
	</table>
  </form>
</div>
</body>
</html>