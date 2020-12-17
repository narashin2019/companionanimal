<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script type="text/javascript">
  $(document).ready(function(){
    $("#memberUpdateBtn").on("click", function(){
      location.href="../member/memberUpdateView";
    })
  })
</script>

<div class="container">
마이페이지 

회원정보 보여주고

하단에 수정 버튼 넣어서 memberUpdate되도록 구현

<button id="memberUpdateBtn" type="button">회원정보수정</button>

</div>