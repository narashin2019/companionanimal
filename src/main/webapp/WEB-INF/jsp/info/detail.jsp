<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>정보/공구게시판</title>
</head>

 <script>
    $(document).ready(function(){
      var formObj = $("form[name='detail']");
      
      // 수정 
      $(".update_btn").on("click", function(){
        formObj.attr("action", "updateForm?infoNo=${detail.infoNo}");
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
    })
  </script> 
  

<body>
<section id="container">

<form name="detail" role="form" method="post">

  <input type="hidden" id="infoNo" name="infoNo" value="${detail.infoNo}" />
  <input type="hidden" id="page" name="page" value="${scri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 

</form>

<div>
<c:if test="${not empty detail}">
번호: ${detail.infoNo}<br>
등록일: <fmt:formatDate value="${detail.createDate}" pattern="yyyy-MM-dd" /><br>  
작성자: ${detail.nickname}<br>
조회수: ${detail.viewCount}<br>
카테고리: ${detail.infoCategory}<br>
제목: ${detail.title}<br>
내용: ${detail.content}<br>
좋아요: ${detail.likeCount}<br>
</c:if>
</div>

<div>
<button type="submit" class="update_btn">수정</button>
<button type="submit" class="delete_btn">삭제</button>
<button type="submit" class="list_btn">목록</button>  
</div>

</section>

</body>
</html>
