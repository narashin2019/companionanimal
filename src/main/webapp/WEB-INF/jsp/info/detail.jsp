<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>정보/공구게시판</title>
</head>
  

<body>
<section id="container">

<div>
<c:if test="${not empty info}">
번호: ${info.infoNo}<br>
등록일: ${info.createDate}<br>
작성자: ${info.nickname}<br>
조회수: ${info.viewCount}<br>
카테고리: ${info.infoCategory}<br>
제목: ${info.title}<br>
내용: ${info.content}<br>
좋아요: ${info.likeCount}<br>
</c:if>
</div>

<div>
<button type="submit" class="update_btn"><a href='updateForm?infoNo=${info.infoNo}'>수정</a></button>
<button type="submit" class="delete_btn"><a href='delete?infoNo=${info.infoNo}'>삭제</a></button>
<button type="submit" class="list_btn"><a href="list.jsp">목록</a></button>  
</div>


<c:if test="${empty requestScope.info}">
<p>해당 게시물이 없습니다.</p>
</c:if>


</section>
</body>
</html>
