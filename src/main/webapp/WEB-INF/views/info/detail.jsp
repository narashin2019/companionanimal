<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>정보/공구 게시판</h1>

<c:if test="${not empty info}">
번호: ${info.infoNo}<br>
등록일: ${info.createDate}<br>
작성자: ${info.nickname}<br>
조회수: ${info.viewCount}<br>
카테고리: ${info.infoCategory}<br>
제목: ${info.title}<br>
내용: ${info.content}<br>
좋아요: ${info.likeCount}<br>

<p>
<a href='delete?infoNo=${info.infoNo}'>삭제</a> 
<a href='updateForm?infoNo=${info.infoNo}'>변경</a>
<a href="list.jsp">목록</a>
</p>
</c:if>

<c:if test="${empty requestScope.info}">
<p>해당 게시물이 없습니다.</p>
</c:if>
