<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <head>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <title>산책 게시판</title>
  </head>
  
  <style type="text/css">
      li {list-style: none; float: left; padding: 6px;}
  </style>

  <body>
  <section id="container">
<form role="form" method="get">

<div>
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
      <td>${item.walkNo}</td>
      <td>${item.walkCategory}</td>
      <td><a href='detail?walkNo=${item.walkNo}'> ${item.title}</a></td>
      <td>${item.nickname}</td>
      <td>${item.createDate}</td>
      <td><c:out value="${item.viewCount}"/></td>
      <td>${item.likeCount}</td>
    </tr>
    </c:forEach>
  </tbody>
  </table>
</div>

<div>
<ul>
    <c:if test="${pageMaker.prev}">
      <li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
      <li><a href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
      <li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
</ul>

</div>

<br>
<br>

<div class="search">
    <select name="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button id="searchBtn" type="button">검색</button>
    
    <script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
</div>
  
<div>
  <a href='form'>새 글</a>
</div>
  
  
</form>
  </section>
  </body>
</html>
