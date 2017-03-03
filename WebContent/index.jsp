<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>

<link href="css/pinkTable.css" rel="stylesheet" type="text/css">
<jsp:include page="pages/basicPage.jsp"></jsp:include>
<script src="<c:url value="/js/pages/index.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>
<body>


<br>
index try to connect java 15:19
<br>

<form class="form-inline">
			
	<f:bundle basename="messages">
	<label for="rg-from"><f:message key="account"></f:message></label>
	</f:bundle>
	<div class="form-group">
	  <input type="text" id="account" name="rg-from" class="form-control">
	</div>
	
	<label for="rg-from"><f:message key="password"></f:message></label>
	<div class="form-group">
	  <input type="text" id="password" name="rg-from" class="form-control">
	</div>
	
	<!--practice restful post-->
	<button type="button" class="btn btn-primary fr" id="searchProductByPrice" onclick="getProductByPrice()">
		登入
	</button>

</form>


	
	
</body>
</html>