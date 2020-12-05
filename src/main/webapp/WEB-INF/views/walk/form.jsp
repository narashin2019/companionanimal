<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<h1>산책 게시판</h1>
<form action='add' method='post'>

<div>
    카테고리:
    <select name="walkCategory">
      <option value="지역">지역</option>
      <option value="정보">정보</option>
    </select>
</div>

제목: <input name='title' type='text'><br>
내용:<br>
<textarea name='content' rows='5' cols='60'></textarea><br>

<button>등록</button>

</form>
