<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
  $(document).ready(function(){
    $("#memberUpdateBtn").on("click", function(){
      location.href="../member/memberUpdateForm";
    })
  })
</script>


<div class="container">
<form role="form" method="get">

<c:if test="${empty loginUser.idPhoto}">
	<div class="idPhotoDefault">
	<img src="${pageContext.servletContext.contextPath}/upload/member/default.jpg" width="200" height="200">
	</div>
</c:if>		 

<c:if test="${not empty loginUser.idPhoto && loginUser.idPhoto ne 'undefined'}">
  <div class="idPhoto">
  <img src='${pageContext.servletContext.contextPath}/upload/member/thumbnail.${loginUser.idPhoto}.jpg' >
  </div>
</c:if>


    <table class="table table-boardered">
     <tr>
       <th><label class="control-label" for="email">이메일</label></th>
       <td>${loginUser.email}</td>        
     </tr>
     <tr>
       <th><label class="control-label" for="nickname">닉네임</label></th>
       <td>${loginUser.nickname}</td>        
     </tr>
    </table>

    <button id="memberUpdateBtn" type="button">회원정보수정</button>


</form>
</div>