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
  
<form action='add' method='post'>

<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>
제목: <input name='title' type='text'><br>
내용:<br>
<textarea name='content' rows='5' cols='60'></textarea><br>

<button>등록</button>

</form>

</section>
</body>
</html>