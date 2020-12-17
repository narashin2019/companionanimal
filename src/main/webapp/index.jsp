<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>

  <meta charset="utf-8">
  
  <c:if test="${not empty refreshUrl}">
  <meta http-equiv="Refresh" content="${refreshUrl}">
  </c:if>
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- 파비콘생기면 넣는 곳 -->
  <link rel="icon" type="image/png" href="images/favicon.ico">

  <title>반려동물 커뮤니티</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="${pageContext.servletContext.getContextPath()}/css/bootstrap.min.css" />

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="${pageContext.servletContext.getContextPath()}/css/common.css" />

  <!-- Bootstrap core JavaScript -->
  <script src="${pageContext.servletContext.getContextPath()}/js/jquery.min.js" type="text/javascript"></script>
  <script src="${pageContext.servletContext.getContextPath()}/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  
</head>

<script type="text/javascript">
  // url 파라미터 지우는 코드
  history.replaceState({}, null, location.pathname);
</script>

<body>

  <!-- nav -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">로고(홈)</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/info/list">정보/공구</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/walk/list">산책친구</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/daily/list">일상공유</a>
          </li>

          <c:if test="${empty loginUser}">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/auth/login">로그인</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/member/register">회원가입</a>
          </li>
          </c:if>

          <c:if test="${not empty loginUser}">
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/member/mypage">${loginUser.nickname}</a>
          </li>
          <li class="nav-item"> <!--active-->
            <a class="nav-link" href="app/auth/logout">로그아웃</a>
          </li>
          </c:if>
        
        </ul>
      </div>
    </div>
  </nav>
  <!-- nav -->
  
  <!-- content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="http://placehold.it/900x400" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
        <h1 class="font-weight-light">메인 상단에 띄울 정보</h1>
        <p>반려동물 커뮤니티 메인화면 index.jsp 블라블라블라 아 졸려 목아파</p>
        <a class="btn btn-primary" href="#">클릭</a>
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <!-- Call to Action Well -->
    <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body">
        <p class="text-white m-0">여기엔 뭘 넣지 뺄까</p>
      </div>
    </div>

    <!-- Content Row -->
    <div class="row">
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">정보/공구</h2>
            <p class="card-text">최근 게시글 리스트 어떻게 불러오지 페이징또해서 5개만 불러오게 해야하나 머리가 아프다</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">더보기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">산책친구</h2>
            <p class="card-text">최근 게시글 리스트</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">더보기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">일상공유</h2>
            <p class="card-text">최근 게시글 리스트</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">더보기</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <!-- content -->

  <!-- footer 
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; coanimal 2020</p>
    </div>
  </footer>
  -->

</body>

</html>