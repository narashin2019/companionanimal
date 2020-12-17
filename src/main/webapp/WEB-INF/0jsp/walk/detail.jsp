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
<title>산책 게시판</title>
</head>

 <script>
    $(document).ready(function(){
      var formObj = $("form[name='detail']");
      
      // 수정 
      $(".update_btn").on("click", function(){
        formObj.attr("action", "updateForm?walkNo=${detail.walkNo}");
        formObj.attr("method", "get");
        formObj.submit();       
      })
      
      // 삭제
      $(".delete_btn").on("click", function(){
          
          var deleteYN = confirm("삭제하시겠습니가?");
        
          if(deleteYN == true){
        formObj.attr("action", "delete");
        formObj.attr("method", "get");
        formObj.submit();
        }
      })
      // 목록
      $(".list_btn").on("click", function(){
        location.href = "list?page=${scri.page}"
        +"&perPageNum=${scri.perPageNum}"
        +"&searchType=${scri.searchType}&keyword=${scri.keyword}";
      })
      
      // 댓글 작성
      $(".replyWriteBtn").on("click", function(){
          var formObj = $("form[name='replyForm']");
          formObj.attr("action", "replyWrite");
          formObj.submit();
        });
      
      // 댓글 수정 View
      $(".replyUpdateBtn").on("click", function(){
        location.href = "replyUpdateView?walkNo=${detail.walkNo}"
                + "&page=${scri.page}"
                + "&perPageNum=${scri.perPageNum}"
                + "&searchType=${scri.searchType}"
                + "&keyword=${scri.keyword}"
                + "&walkReplyNo="+$(this).attr("data-rno");
      });
          
      // 댓글 삭제 View
      $(".replyDeleteBtn").on("click", function(){
        location.href = "replyDeleteView?walkNo=${detail.walkNo}"
          + "&page=${scri.page}"
          + "&perPageNum=${scri.perPageNum}"
          + "&searchType=${scri.searchType}"
          + "&keyword=${scri.keyword}"
          + "&walkReplyNo="+$(this).attr("data-rno");
      });
    })
     
    function fn_fileDown(fileNo){
      var formObj = $("form[name='detail']");
      $("#file_no").attr("value", fileNo); //file_no로 하면 안되더라 왜징
      formObj.attr("action", "fileDown");
      formObj.submit();
    }
  </script> 
  

<body>
<section id="container">

<form name="detail" role="form" method="post">
  <input type="hidden" id="walkNo" name="walkNo" value="${detail.walkNo}" />
  <input type="hidden" id="page" name="page" value="${scri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
  <input type="hidden" id="file_no" name="file_no" value=""> 
</form>

<div>
번호: ${detail.walkNo}<br>
등록일: <fmt:formatDate value="${detail.createDate}" pattern="yyyy-MM-dd" /><br>  
작성자: ${detail.nickname}<br>
조회수: ${detail.viewCount}<br>
카테고리: ${detail.walkCategory}<br>
제목: ${detail.title}<br>
내용: ${detail.content}<br>
좋아요: ${detail.likeCount}<br>
</div>

<hr>
<span>파일 목록</span>
<div class="form-group">
  <c:forEach var="file" items="${file}">
    <a href="#" onclick="fn_fileDown('${file.file_no}'); return false;">${file.org_file_name}</a>(${file.file_size}kb)<br>
  </c:forEach>
</div>
<hr>


<div>
<button type="submit" class="update_btn">수정</button>
<button type="submit" class="delete_btn">삭제</button>
<button type="submit" class="list_btn">목록</button>  
</div>

<!-- 댓글 -->
<div id="reply">
 <ol class="replyList">
    <c:forEach items="${replyList}" var="replyList">
      <li>
        <p>
                작성자 : ${replyList.nickname}<br />
                작성일 : ${replyList.createDate}
        </p>

        <p>${replyList.content}</p>
        <div>
                  <button type="button" class="replyUpdateBtn" data-rno="${replyList.walkReplyNo}">수정</button>
                  <button type="button" class="replyDeleteBtn" data-rno="${replyList.walkReplyNo}">삭제</button>
                </div>
      </li>
    </c:forEach>   
  </ol>
</div>

<form name="replyForm" method="post">
  <input type="hidden" id="walkNo" name="walkNo" value="${detail.walkNo}" />
  <input type="hidden" id="page" name="page" value="${scri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 

  <div>
  <!--  
    <label for="nickname">댓글 작성자</label><input type="text" id="nickname" name="nickname" /><br/>
  -->

    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
  </div>
  <div>
   <button type="button" class="replyWriteBtn">작성</button>
  </div>
</form>


</section>

</body>
</html>