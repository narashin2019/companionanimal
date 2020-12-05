
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>산책 게시판</title>
</head>
  

<body>
<section id="container">

<div>
<c:if test="${not empty walk}">
번호: ${walk.walkNo}<br>
등록일: ${walk.createDate}<br>
작성자: ${walk.nickname}<br>
조회수: ${walk.viewCount}<br>
카테고리: ${walk.walkCategory}<br>
제목: ${walk.title}<br>
내용: ${walk.content}<br>
좋아요: ${walk.likeCount}<br>
</c:if>
</div>

<div>
<button type="submit" class="update_btn"><a href='updateForm?walkNo=${walk.walkNo}'>수정</a></button>
<button type="submit" class="delete_btn"><a href='delete?walkNo=${walk.walkNo}'>삭제</a></button>
<button type="submit" class="list_btn"><a href="list.jsp">목록</a></button>  
</div>


<c:if test="${empty requestScope.walk}">
<p>해당 게시물이 없습니다.</p>
</c:if>


</section>
</body>
</html>
