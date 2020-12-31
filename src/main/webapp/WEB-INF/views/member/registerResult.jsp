<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
 // url 파라미터 지우는 코드
  history.replaceState({}, null, location.pathname);
</script>
 

<c:if test="${result == 'fail'}">
<p> 회원가입에 실패했습니다.</p>
</c:if>


<c:if test="${result == 'ok'}">
<p> 회원가입에 성공했습니다.</p>
</c:if>

