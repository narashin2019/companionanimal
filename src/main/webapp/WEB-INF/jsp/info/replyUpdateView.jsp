<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        location.href = "detail?infoNo=${replyUpdate.infoNo}"
             + "&page=${scri.page}"
             + "&perPageNum=${scri.perPageNum}"
             + "&searchType=${scri.searchType}"
             + "&keyword=${scri.keyword}";
      })
    
      $(".update_btn").on("click", function(){
        if(fn_valiChk()){
          return false;
        }
        formObj.attr("action", "updateReply");
        formObj.attr("method", "post");
        formObj.submit();
      })
      
      
    })
    
  </script>
  <body>
  
    <div id="root">
      <header>
      </header>   
      <section id="container">
      
        <form name="updateForm" role="form" method="post" action="replyUpdate">
        
          <input type="hidden" name="infoNo" value="${replyUpdate.infoNo}" readonly="readonly"/>
          <input type="hidden" id="infoReplyNo" name="infoReplyNo" value="${replyUpdate.infoReplyNo}" />
          <input type="hidden" id="page" name="page" value="${scri.page}"> 
          <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
          <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
          <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
          <table>
            <tbody>
              <tr>
                <td>
                  <label for="content">댓글 내용</label><input type="text" id="content" name="content" value="${replyUpdate.content}"/>
                </td>
              </tr> 
              
            </tbody>      
          </table>
          <div>
            <button type="submit" class="update_btn">저장</button>
            <button type="button" class="cancel_btn">취소</button>
          </div>
        </form>
      </section>
      <hr />
    </div>
  </body>
</html>
 