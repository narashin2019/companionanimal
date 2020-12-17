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
  
  <div>
  <form action='search' method='get'>
        검색어: <input name='keyword' type='text'>
     <button>검색</button>
  </form>
  </div>

  </section>
  </body>
  </html>