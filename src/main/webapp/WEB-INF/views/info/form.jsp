<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <head>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <title>정보/공구게시판</title>
  </head>

  <script type="text/javascript">
    $(document).ready(function(){
      var formObj = $("form[name='addForm']");
      $(".write_btn").on("click", function(){
        if(fn_valiChk()){
          return false;
        }
        formObj.attr("action", "add");
        formObj.attr("method", "post");
        formObj.submit();
      });
    })
    function fn_valiChk(){
      var regForm = $("form[name='addForm'] .chk").length;
      for(var i = 0; i<regForm; i++){
        if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
          alert($(".chk").eq(i).attr("title"));
          return true;
        }
      }
    }
  </script>

<body>
<section id="container">
  
<form name='addForm' action='add' method='post'>

<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

<label for='title'>제목:</label><input type="text" id="title" name="title" class="chk" title="제목을 입력하세요"><br>

<label for='content'>내용:</label><br>
<textarea id="content" name="content" class="chk" title="내용을 입력하세요" rows='5' cols='60'></textarea><br>

<button class="write_btn" type="submit">등록</button>

</form>

</section>
</body>
</html>