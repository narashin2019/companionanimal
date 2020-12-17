<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
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

<body>

<tiles:insertAttribute name="nav"/>

<tiles:insertAttribute name="content"/>

 
</body>
</html>