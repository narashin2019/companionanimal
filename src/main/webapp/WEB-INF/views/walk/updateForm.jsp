<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 
  <script type="text/javascript">
    $(document).ready(function(){
      var formObj = $("form[name='updateForm']");
      
      $(document).on("click","#fileDel", function(){
          $(this).parent().remove();
        })
        
        fn_addFile();
      
      $(".cancel_btn").on("click", function(){
          event.preventDefault();
          location.href = "detail?walkNo=${update.walkNo}"
               + "&page=${scri.page}"
               + "&perPageNum=${scri.perPageNum}"
               + "&searchType=${scri.searchType}"
               + "&keyword=${scri.keyword}";
        })
      
      $(".update_btn").on("click", function(){
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
      console.log("삭제할 값 받아왔나")
    fileNoArry.push(value);
      console.log(value)
    fileNameArry.push(name);
      console.log(name)
    $("#fileNoDel").attr("value", fileNoArry);
      console.log(fileNoArry)
    $("#fileNameDel").attr("value", fileNameArry);
      console.log(fileNameArry)
  }
  </script>


<div class="container">

<form name='updateForm' action='update' method='post' enctype="multipart/form-data">
<input type="hidden" name="walkNo" value="${update.walkNo}" readonly="readonly"/>
<input type="hidden" id="page" name="page" value="${scri.page}"> 
<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
<input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""> 
<input type="hidden" id="fileNameDel" name="fileNameDel[]" value=""> 

<input name='walkNo' type='hidden' value='${update.infoNo}'>

<div>
    카테고리:
    <select name="walkCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

          제목: <input name='title' type='text' value='${update.title}'><br>
          내용:<textarea name='content' rows='5' cols='60'>${update.content}</textarea><br>

<div id="fileIndex">
 <c:forEach var="file" items="${file}" varStatus="var">
  <div>
    <input type="hidden" id="file_no" name="file_no_${var.index}" value="${file.file_no }">
    <input type="hidden" id="file_name" name="file_name" value="file_no_${var.index}">
    <a href="#" id="fileName" onclick="return false;">${file.org_file_name}</a>(${file.file_size}kb)
    <button id="fileDel" onclick="fn_del('${file.file_no}','file_no_${var.index}');" type="button">삭제</button><br>
  </div>
  </c:forEach>
<button type="button" class="fileAdd_btn">파일추가</button>
</div>


<div>
<button class="update_btn" type="submit">변경</button>
<button class="cancel_btn" type="submit">취소</button>
</div>

</form>
</div>
