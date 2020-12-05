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

<form action='update' method='post' >
번호: ${info.infoNo}<br>
<input name='infoNo' type='hidden' value='${info.infoNo}'>

<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

<div>
제목: <input name='title' type='text' value='${info.title}'><br>

내용:<br>
<textarea name='content' rows='5' cols='60'>${info.content}</textarea><br>
</div>


<button>변경</button>

</form>
</section>
</body>
</html>