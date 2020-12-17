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
    <form action="memberUpdate" method="post">
      <div class="form-group has-feedback">
        <label class="control-label" for="email">이메일</label>
        <input class="form-control" type="text" id="email" name="email" value="${member.email}" readonly="readonly"/>
      </div>
      <div class="form-group has-feedback">
        <label class="control-label" for="password">패스워드</label>
        <input class="form-control" type="password" id="password" name="password" />
      </div>
      <div class="form-group has-feedback">
        <label class="control-label" for="nickname">닉네임</label>
        <input class="form-control" type="text" id="nickname" name="nickname" value="${member.nickname}"/>
      </div>
      <div class="form-group has-feedback">
        <label class="control-label" for="idPhoto">프로필사진</label>
        <input class="form-control" type="text" id="idPhoto" name="idPhoto" value="${member.idPhoto}"/>
      </div>
      <div class="form-group has-feedback">
        <button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
        <button class="cancel btn btn-danger" type="button">취소</button>
      </div>
    </form>
</div>
  

