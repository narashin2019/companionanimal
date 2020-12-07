<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
  <head>
    <!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <!-- 제이쿼리 -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>홈</title>
  </head>
  
<script type="text/javascript">
  $(document).ready(function(){
    $("#logoutBtn").on("click", function(){
      location.href="logout";
    })
    
  })
</script>

<body>
  <form name='lohinForm' method="post" action="login">
    <c:if test="${member == null}">
      <div>
        <label for="email"></label>
        <input type="text" id="email" name="email">
      </div>
      <div>
        <label for="password"></label>
        <input type="password" id="password" name="password">
      </div>
      <div>
        <button type="submit">로그인</button>
        <button type="button">회원가입</button>
      </div>
    </c:if>
    <c:if test="${member != null }">
      <div>
        <p>${member.nickname}님 환영 합니다.</p>
        <button id="logoutBtn" type="button">로그아웃</button>
      </div>
    </c:if>
    <c:if test="${msg == false}">
      <p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
    </c:if>
  </form>
</body>
</html>