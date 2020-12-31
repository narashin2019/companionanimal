<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
$(document).ready(function(){
    // 취소
    $(".cancel").on("click", function(){
      location.href = "../auth/login";
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
      if($("#password2").val()==""){
          alert("비밀번호를 확인해주세요.");
          $("#password2").focus();
          return false;
      }
      if($("#password").val() != $("#password2").val()){
          alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해 주세요."); 
          $("#password").focus();
          return false; 
      }
      if ($("#password").val().length < 8) {
          alert("비밀번호는 8자 이상으로 설정해야 합니다.");
          $("#password").val("").focus();
          return false;
      }
      if($("#nickname").val()==""){
        alert("닉네임을 입력해주세요.");
        $("#nickname").focus();
        return false;
      }

    });
  })
  
  function fn_idChk(){
    $.ajax({
      url : "/companionanimal/app/member/idChk",
      type : "post",
      dataType : "json",
      data : {"email" : $("#email").val()},
      success : function(data){
        if(data == 1){
          alert("중복된 이메일입니다.");
        }else if(data == 0){
          $("#idChk").attr("value", "Y");
          alert("사용가능한 이메일입니다.");
        }else {
        	alert("이메일을 입력해주세요.");
        }
      }
    })
  }
  
  function fn_nameChk(){
    $.ajax({
      url : "/companionanimal/app/member/nameChk",
      type : "post",
      dataType : "json",
      data : {"nickname" : $("#nickname").val()},
      success : function(data){
    	  
        if(data == 1){
          alert("중복된 닉네임입니다.");
        }else if(data == 0){
          $("#idChk").attr("value", "Y");
          alert("사용가능한 닉네임입니다.");
        } else {
        	alert("닉네임을 입력해 주세요.");
        }
      }
    })
  }
</script>


<div class="container">
<div class="row">
<div class="col-sm-12 text-center" >
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<h2>회원가입</h2>
    
  <form action='register' method='post' id='regForm'>
    <table class="table table-boardered">
     <tr>
       <th><label class="control-label" for="email">이메일</label></th>
       <td><input class="form-control" type="email" id="email" name="email" placeholder="이메일을 넣으세요">    
       <button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>  </td>  
     </tr>
     <tr>
       <th><label class="control-label" for="password">비밀번호</label></th>
       <td><input class="form-control"  type="password" id="password" name="password" placeholder="비밀번호를 넣으세요"></td>        
     </tr>
     <tr>
       <th><label class="control-label" for="password">비밀번호 확인</label></th>
       <td><input class="form-control"  type="password" id="password2" name="password2" placeholder="비밀번호를 확인하세요"></td>        
     </tr>
     <tr>
     <th><label class="control-label" for="nickname">닉네임</label></th>
       <td><input class="form-control"  type="text" id="nickname" name="nickname" placeholder="닉네임을 입력하세요">
       <button class="idChk" type="button" id="nameChk" onclick="fn_nameChk();" value="N">중복확인</button> </td>        
     </tr>
    </table>
  
	  <div>
		<button class="btn btn-success" type="submit" id="submit">회원가입</button>
		<button class="cancel btn btn-danger" type="button">취소</button>
	  </div>
	  
  </form>
</div>
</div>
</div>
</div>
  
