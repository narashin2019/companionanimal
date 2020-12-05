<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<h1>산책 게시판</h1>

<form name="updateForm" role="form" action='update' method='post'>
번호: ${walk.walkNo}<br>
<input name='walkNo' type='hidden' value='${walk.walkNo}'>
<div>
    카테고리:
    <select name="walkCategory">
      <option value="지역">지역</option>
      <option value="정보">정보</option>
    </select>
</div>

<div>
제목: <input name='title' type='text' value='${walk.title}'><br>

내용:<br>
<textarea name='content' rows='5' cols='60'>${walk.content}</textarea><br>
</div>


<button>변경</button>

</form>