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
      var formObj = $("form[name='updateForm']");
      
      $(".cancel_btn").on("click", function(){
          event.preventDefault();
          location.href = "detail?infoNo=${update.infoNo}"
               + "&page=${scri.page}"
               + "&perPageNum=${scri.perPageNum}"
               + "&searchType=${scri.searchType}"
               + "&keyword=${scri.keyword}";
        })
      
      $(".update_btn").on("click", function(){
        if(fn_valiChk()){
          return false;
        }
        formObj.attr("action", "update");
        formObj.attr("method", "post");
        formObj.submit();
      })
    })
      
  </script>


<body>
<section id="container">

<form name='updateForm' action='update' method='post' >

번호: ${update.infoNo}<br>
<input name='infoNo' type='hidden' value='${update.infoNo}'>

<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

<div>
제목: <input name='title' type='text' value='${update.title}'><br>

내용:<br>
<textarea name='content' rows='5' cols='60'>${update.content}</textarea><br>
</div>

<button class="update_btn" type="submit">변경</button>
<button class="cancel_btn" type="submit">취소</button>

</form>
</section>
</body>
</html>