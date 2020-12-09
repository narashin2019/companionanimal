<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
  <!-- CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <!-- 부가적인 테마 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
  <!-- 제이쿼리 -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>정보/공구게시판</title>
</head>
  
  
  <script type="text/javascript">
    $(document).ready(function(){
      var formObj = $("form[name='updateForm']");
      
      $(document).on("click","#fileDel", function(){
          $(this).parent().remove();
        })
        
        fn_addFile();
      
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
      
    function fn_addFile(){
      var fileIndex = 1;
      //$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
      $(".fileAdd_btn").on("click", function(){
        $("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
      });
      $(document).on("click","#fileDelBtn", function(){
        $(this).parent().remove();
        
      });
    }
    var fileNoArry = new Array();
    var fileNameArry = new Array();
    function fn_del(value, name){
      
      fileNoArry.push(value);
      fileNameArry.push(name);
      $("#fileNoDel").attr("value", fileNoArry);
      $("#fileNameDel").attr("value", fileNameArry);
    }
  </script>


<body>

<section id="container">

<form name='updateForm' action='update' method='post' enctype="multipart/form-data">
<input type="hidden" name="infoNo" value="${update.infoNo}" readonly="readonly"/>
<input type="hidden" id="page" name="page" value="${scri.page}"> 
<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
<input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""> 
<input type="hidden" id="fileNameDel" name="fileNameDel[]" value=""> 


<input name='infoNo' type='hidden' value='${update.infoNo}'>

<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

<table>
  <tbody>
    <tr>
      <td>
          제목: <input name='title' type='text' value='${update.title}'><br>
      </td>
    </tr> 
    <tr>
      <td>
          내용:<textarea name='content' rows='5' cols='60'>${update.content}</textarea><br>
      </td>
   </tr>
   <tr>
     <td id="fileIndex">
      <c:forEach var="file" items="${file}" varStatus="var">
       <div>
         <input type="hidden" id="file_no" name="file_no_${var.index}" value="${file.file_no }">
         <input type="hidden" id="file_name" name="file_name" value="file_no_${var.index}">
         <a href="#" id="fileName" onclick="return false;">${file.org_file_name}</a>(${file.file_size}kb)
         <button id="fileDel" onclick="fn_del('${file.file_no}','file_no_${var.index}');" type="button">삭제</button><br>
       </div>
       </c:forEach>
      </td>
    </tr>
  </tbody>      
</table>

<div>
<button class="update_btn" type="submit">변경</button>
<button class="cancel_btn" type="submit">취소</button>
<button type="button" class="fileAdd_btn">파일추가</button>
</div>

</form>
</section>
</body>
</html>
