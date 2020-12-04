<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<h1>정보/공구 게시판</h1>

<form name="updateForm" role="form" action='update' method='post'>
번호: ${info.infoNo}<br>
<div>
    카테고리:
    <select name="infoCategory">
      <option value="정보">정보</option>
      <option value="공구">공구</option>
    </select>
</div>

<div>
제목: <input name='title' type='text' value='${info.title}'><br>

내용:<br>
<textarea name='content' rows='5' cols='60'>${info.content}</textarea><br>
</div>


<button>변경</button>

</form>
