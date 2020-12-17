<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
 // url 파라미터 지우는 코드
  history.replaceState({}, null, location.pathname);
</script>


<div class="container">
  <c:if test="${empty loginUser}">
    <form name='loginForm' method="post" action="login">
      <div>
      <label for="email"></label>
            이메일: <input type="email" id="email" name="email">
      </div>
      <div>
      <label for="password"></label>
           비밀번호: <input type="password" id="password" name="password">
      </div>
      <input type='checkbox' name='saveEmail'> 이메일 저장<br>
      <div>
        <button type="submit">로그인</button>
        <a href="../member/register">회원가입</a>
      </div>
    </form>
  </c:if>

  <c:if test="${not empty loginUser}">
    <p>${loginUser.nickname}님</p>
  </c:if>

<!-- 찾아서 코드 넣기 컨트롤러 -->
  <c:if test="${msg == false}">
    <p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
  </c:if>
  
</div>
