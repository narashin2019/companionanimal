<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.profile-userpic img {
  float: none;
  margin: 0 auto;
  width: 50%;
  height: 50%;
  -webkit-border-radius: 50% !important;
  -moz-border-radius: 50% !important;
  border-radius: 50% !important;
}
</style>

<script type="text/javascript">
  $(document).ready(function(){
    $("#memberUpdateBtn").on("click", function(){
      location.href="../member/memberUpdateView";
    })
  })
</script>


<div class="container">
<form role="form" method="get">

		<div class="profile-userpic">
		  <img src="http://keenthemes.com/preview/metronic/theme/assets/admin/pages/media/profile/profile_user.jpg" class="img-responsive" alt="">
		</div>

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