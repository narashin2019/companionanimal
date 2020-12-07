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
    <title>회원가입</title>
  </head>
  
  <script type="text/javascript">
    $(document).ready(function(){
      // 취소 버튼
      $(".cencle").on("click", function(){
        
        location.href = "login";
                
      })
    
      $("#submit").on("click", function(){
        if($("#email").val()==""){
          alert("이메일을 입력해주세요.");
          $("#email").focus();
          return false;
        }
        if($("#password").val()==""){
          alert("비밀번호를 입력해주세요.");
          $("#password").focus();
          return false;
        }
      });
      
        
      
    })
  </script>
  <body>
    <section id="container">
      
      <form action="register" method="post">
      
        <div class="form-group has-feedback">
          <label class="control-label" for="email">이메일</label>
          <input class="form-control" type="text" id="email" name="email" />
        </div>
        <div class="form-group has-feedback">
          <label class="control-label" for="password">비밀번호</label>
          <input class="form-control" type="password" id="password" name="password" />
        </div>
        <div class="form-group has-feedback">
          <label class="control-label" for="nickname">닉네임</label>
          <input class="form-control" type="text" id="nickname" name="nickname" />
        </div>
        <div class="form-group has-feedback">
          <label class="control-label" for="idPhoto">프로필사진</label>
          <input class="form-control" type="text" id="idPhoto" name="idPhoto" />
        </div>
        <div class="form-group has-feedback">
          <label class="control-label" for="loginmethod">로그인메소드</label>
          <input class="form-control" type="text" id="loginmethod" name="loginmethod" />
        </div>
        
        <div class="form-group has-feedback">
          <button class="btn btn-success" type="submit" id="submit">회원가입</button>
          <button class="cencle btn btn-danger" type="button">취소</button>
        </div>
      </form>
    </section>
    
  </body>
  
</html>