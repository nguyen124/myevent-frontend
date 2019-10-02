<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<link href="<c:url value='static/css/app.css' />" rel="stylesheet"></link>

<%@ include file="/WEB-INF/jsp/header.jsp"%>
</head>

<body ng-app="myApp" class="ng-cloak">
	<div class="container">
		<h2 class="text-muted">My Event</h2>
		<div ng-view></div>
	</div>
	<%@ include file="WEB-INF/jsp/footer.jsp"%>
</body>

</html>