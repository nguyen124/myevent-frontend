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

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular-route.js"></script>
	<script src="<c:url value='static/js/app.js' />"></script>
	<script src="<c:url value='static/js/service/user_service.js' />"></script>
	<script src="<c:url value='static/js/controller/user_controller.js' />"></script>
</body>

</html>