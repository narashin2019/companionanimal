<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
 // url 파라미터 지우는 코드
  history.replaceState({}, null, location.pathname);
</script>


<c:if test="${not empty loginUser}">
<p>'${loginUser.nickname}'님 환영합니다.</p>
</c:if>

<c:if test="${empty loginUser}">
<p>사용자 정보가 유효하지 않습니다.</p>
</c:if>

