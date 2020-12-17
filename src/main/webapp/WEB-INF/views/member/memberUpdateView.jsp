<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
  $(document).ready(function(){
    // 취소
    $(".cancel").on("click", function(){
      location.href = "mypage";
    })
  
    $("#submit").on("click", function(){
      if($("password").val()==""){
        alert("비밀번호를 입력해주세요.");
        $("#password").focus();
        return false;
      }
      if($("#nickname").val()==""){
        alert("닉네임을 입력해주세요.");
        $("#nickname").focus();
        return false;
      }
    });
  })
</script>

<div class="container">
<div class="row">
<div class="col-sm-12 text-center" >
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<h2>회원정보수정</h2>
  <form action="memberUpdate" method="post" enctype='multipart/form-data'>
    <table class="table table-boardered">
    <tr>
		  <th><label class="control-label" for="email">이메일</label></th>
		  <td><input class="form-control" type="email" id="email" name="email" value="${loginUser.email}" readonly="readonly"></td>        
    </tr>      
    <tr>
		     <th><label class="control-label" for="password">비밀번호</label></th>
		     <td><input class="form-control"  type="password" id="password" name="password"></td>        
		</tr>
		   <!-- 비밀번호 확인
		<tr>
		  <th><label class="control-label" for="password">비밀번호</label></th>
		  <td><input class="form-control"  type="password" id="password" name="password" placeholder="비밀번호를 확인하세요"></td>        
		</tr>
		-->       
		<tr>
		  <th><label class="control-label" for="nickname">닉네임</label></th>
		  <td><input class="form-control"  type="text" id="nickname" name="nickname" value="${loginUser.nickname}"></td>        
		</tr>
		<tr>
		 <th><label class="control-label" for="idPhoto">프로필사진</label></th>
		 <td><input class="form-control"  type="file" id="idPhoto" name="idPhoto" value="${loginUser.idPhoto}"></td>        
		</tr>
    </table>
    
    <div>
        <button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
        <button class="cancel btn btn-danger" type="button">취소</button>
    </div>
    </form>
</div>
</div>
</div>
</div>

