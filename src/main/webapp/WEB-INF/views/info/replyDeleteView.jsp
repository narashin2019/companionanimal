<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



  <script type="text/javascript">
    $(document).ready(function(){
      var formObj = $("form[name='updateForm']");
      
      $(".cancel_btn").on("click", function(){
        location.href = "detail?infoNo=${replyDelete.infoNo}"
             + "&page=${scri.page}"
             + "&perPageNum=${scri.perPageNum}"
             + "&searchType=${scri.searchType}"
             + "&keyword=${scri.keyword}";
      })
      
    })
    
  </script>

    <div class="container">
        <form name="updateForm" role="form" method="post" action="replyDelete">
          <input type="hidden" name="infoNo" value="${replyDelete.infoNo}" readonly="readonly"/>
          <input type="hidden" id="infoReplyNo" name="infoReplyNo" value="${replyDelete.infoReplyNo}" />
          <input type="hidden" id="page" name="page" value="${scri.page}"> 
          <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
          <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
          <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
            
          <div>
            <p>삭제 하시겠습니까?</p>
            <button type="submit" class="delete_btn">예 삭제합니다.</button>
            <button type="button" class="cancel_btn">아니오. 삭제하지 않습니다.</button>
          </div>
        </form>
    </div>
