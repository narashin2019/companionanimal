<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


  <!-- nav -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="../../">로고(홈)</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../info/list">정보/공구</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../walk/list">산책친구</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../daily/list">일상공유</a>
          </li>

          <c:if test="${empty loginUser}">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../auth/login">로그인</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../member/register">회원가입</a>
          </li>
          </c:if>

          <c:if test="${not empty loginUser}">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../member/mypage">${loginUser.nickname}</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="../auth/logout">로그아웃</a>
          </li>
          </c:if>
        
        </ul>
      </div>
    </div>
  </nav>
  <!-- nav -->


    
  
<br>
<br>

