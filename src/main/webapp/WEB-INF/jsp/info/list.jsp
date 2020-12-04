<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <h1>정보/공구 게시판</h1>
  <a href='form'>새 글</a><br>
  <table border='1'>
  <thead>
    <th style="width: 5%">번호</th>
    <th style="width: 10%">카테고리</th>
    <th style="width: 45%">제목</th>
    <th style="width: 10%">작성자</th>
    <th style="width: 10%">작성일</th>
    <th style="width: 5%">조회수</th>
    <th style="width: 5%">좋아요</th>
  </thead>
  <tbody>
    <c:forEach items="${list}" var="item">
    <tr>
      <td>${item.infoNo}</td>
      <td>${item.infoCategory}</td>
      <td><a href='detail?infoNo=${item.infoNo}'> ${item.title}</a></td>
      <td>${item.nickname}</td>
      <td>${item.createDate}</td>
      <td><c:out value="${item.viewCount}"/></td>
      <td>${item.likeCount}</td>
    </tr>
    </c:forEach>
  
  </tbody>
  
  </table>
