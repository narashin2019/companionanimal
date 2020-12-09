<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <head>
    <!--  CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
    <title>정보/공구 게시판</title>
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
  
    <div id="root">
      <section id="container">
        <form name='addForm' action='add' method='post' enctype="multipart/form-data">
        
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
                    <label for="title">제목</label><input type="text" id="title" name="title" class="chk" title="제목을 입력하세요."/>
                  </td>
                </tr> 
                <tr>
                  <td>
                    <label for="content">내용</label><textarea id="content" name="content" class="chk" title="내용을 입력하세요."></textarea>
                  </td>
                </tr>
     <!--       <tr>
                  <td>
                    <label for="writer">작성자</label><input type="text" id="writer" name="writer" class="chk" title="작성자를 입력하세요." value="${member.userId}" />
                  </td>
                <tr>
      -->
                <tr>
                  <td>
                    <input type="file" name="file">
                  </td>
                <tr>
                  <td>            
                    <button class="write_btn" type="submit">작성</button> 
                  </td>
                </tr> 
            
            </tbody>      
          </table>
        </form>
        
      </section>
      <hr />
    </div>
  </body>
</html>