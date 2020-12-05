<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>산책친구 게시판</h1>

<c:if test="${not empty walk}">
번호: ${walkno.wakrNo}<br>
등록일: ${walk.createDate}<br>
조회수: ${walk.viewCount}<br>
제목: ${walk.title}<br>
내용: ${walk.content}<br>
좋아요: ${walk.likeCount}<br>

<p>
<a href='delete?walkNo=${wakr.walkNo}'>삭제</a> 
<a href='updateForm?walkNo=${walk.walkNo}'>변경</a>
<a href="list.jsp">목록</a>
</p>
</c:if>

<c:if test="${empty requestScope.wark}">
<p>해당 게시물이 없습니다.</p>
</c:if>
