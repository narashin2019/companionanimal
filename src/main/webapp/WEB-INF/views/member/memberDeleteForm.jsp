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
        if($("#password").val()==""){
          alert("비밀번호를 입력해주세요.");
          $("#password").focus();
          return false;
        }
        $.ajax({
          url : "/companionanimal/app/member/passChk",
          type : "POST",
          dateType : "json",
          data : $("#memberDeleteForm").serializeArray(),
          success: function(data){
            
            if(data==true){
              if(confirm("회원탈퇴하시겠습니까?")){
                $("#memberDeleteForm").submit();
              }
            }else{
              alert("패스워드가 틀렸습니다.");
              return;
            }
          }
        })
      });
    })
  </script>

<div class="container">
<div class="row">
<div class="col-sm-12 text-center" >
<div class="col-sm-3">
</div>
<div class="col-sm-6">
  <form name='memberDeleteForm' id='memberDeleteForm' action="memberDelete" method="post">
    <table class="table table-boardered">
      <tr>
        <th><label class="control-label" for="email">이메일</label></th>
        <td><input class="form-control" type="email" id="email" name="email" value="${loginUser.email}" readonly="readonly"></td> 
      </tr>
      <tr>
        <th><label class="control-label" for="password">비밀번호</label></th>
        <td><input class="form-control"  type="password" id="password" name="password"></td>        
      </tr>
      <tr>
        <th><label class="control-label" for="nickname">닉네임</label></th>
        <td><input class="form-control"  type="text" id="nickname" name="nickname" value="${loginUser.nickname}" readonly="readonly"></td>        
      </tr>
    </table>
    </form>
      <div>
        <button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
        <button class="cancel btn btn-danger" type="button">취소</button>
      </div>
      

</div>
</div>
</div>
</div>
