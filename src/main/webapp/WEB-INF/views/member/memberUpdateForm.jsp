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
        if($("#nickname").val()==""){
          alert("닉네임을 입력해주세요.");
          $("#nickname").focus();
          return false;
        }
        $.ajax({
          url : "/companionanimal/app/member/passChk",
          type : "POST",
          dateType : "json",
          data : $("#memberUpdateForm").serializeArray(),
          success: function(data){
            
            if(data==true){
              if(confirm("회원수정하시겠습니까?")){
            	  console.log("수정하겠다 submit작동전");
                $("#memberUpdateForm").submit();
              }
              
            }else{
              alert("패스워드가 틀렸습니다.");
              return;
              
            }
          }
        })
      });
    })
  
  $(function() {
    //입력값 검증 정규표현식
    const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
    
    //패스워드 입력값 검증.
    $('#password').on('keyup', function() {
       if(!getPwCheck.test($("#password").val()) || $("#password").val().length < 8){
            $('#pwChk').html('<b style="font-size:14px;color:red;">특수문자 포함 8자이상 입력해주세요.</b>');
        } else {
          $('#pwChk').html('');
        }
        
    });
    
    //패스워드 확인란 입력값 검증.
    $('#password2').on('keyup', function() {
        //비밀번호 확인란 공백 확인
       if($("#password").val() != $("#password2").val()){
            $('#pwChk2').html('<b style="font-size:14px;color:red;">비밀번호가 일치하지 않습니다.</b>');
        } else {
          $('#pwChk2').html('');
        }
        
    });
  });
  </script>

<div class="container">
<div class="row">
<div class="col-sm-12 text-center" >
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<h2>회원정보수정</h2>
  <form name='memberUpdateForm' id='memberUpdateForm' action='memberUpdate' method='post' enctype="multipart/form-data">
    <table class="table table-boardered">
    <tr>
		  <th><label class="control-label" for="email">이메일</label></th>
		  <td><input class="form-control" type="email" id="email" name="email" value="${loginUser.email}" readonly="readonly"></td>        
    </tr>      
    <tr>
		     <th><label class="control-label" for="password">비밀번호</label></th>
		     <td>
		     <input class="form-control"  type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
		     <span id="pwChk"></span>
		     </td>        
		</tr>
		<tr>
		  <th><label class="control-label" for="password">비밀번호</label></th>
		  <td>
		  <input class="form-control"  type="password" id="password2" name="password2" placeholder="비밀번호를 확인하세요">
		  <span id="pwChk2"></span>
		  </td>        
		</tr>
		<tr>
		  <th><label class="control-label" for="nickname">닉네임</label></th>
		  <td><input class="form-control"  type="text" id="nickname" name="nickname" value="${loginUser.nickname}"></td>        
		</tr>
    <tr>
      <th><label class="control-label" for="idPhoto">프로필사진</label></th>
      <td>
      <!-- 로그인유저의 idPhoto가 있다면-->
       <c:if test="${not empty loginUser.idPhoto}">
       <div class="idPhoto">
       <img src='${pageContext.servletContext.contextPath}/upload/member/thumbnail.${loginUser.idPhoto}.jpg' >
       </div>
       </c:if>
       <!-- 로그인유저의 idPhoto가없다면 디폴트 이미지 노출 -->
       <c:if test="${empty loginUser.idPhoto}">
		   <div class="idPhotoDefault">
		   <img src="${pageContext.servletContext.contextPath}/upload/member/default.jpg" width="200" height="200">
		   </div>
       </c:if>
     </td>        
    </tr>
    </table>
 
 <!-- 이미지 파일 변경하는 부분 -->  
<div class="inputArea">
<label for="photo"></label>
<input type="file" id="photo" name="photo" value="${loginUser.idPhoto}">
<div class="select_img"><img src="" /></div>

<script>
$("#photo").change(function(){
 if(this.files && this.files[0]) {
  var reader = new FileReader;
  reader.onload = function(data) {
   $(".select_img img").attr("src", data.target.result).width(200);        
  }
  reader.readAsDataURL(this.files[0]);
 }
});
</script>
</div>
</form>
    
    <div>
       <button class="submit btn btn-success" type="button" id="submit">회원정보수정</button>
       <button class="cancel btn btn-danger" type="button">취소</button>
    </div>
</div>
</div>
</div>
</div>

