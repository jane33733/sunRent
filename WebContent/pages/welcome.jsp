<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>

<link href="css/pinkTable.css" rel="stylesheet" type="text/css">
<jsp:include page="basicPage.jsp"></jsp:include>
<script src="<c:url value="/js/pages/index.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>
<body>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
			<!--Sidebar content-->
			
			<br>
			index try to connect java 15:19
			<br>
			
			<!--practice restful get-->
			<button type="button" class="btn btn-primary fr" id="searchProduct" onclick="getAllProduct()">
				顯示產品GET
			</button>
			
			<br>
			---------
			<br>
			
		
    	
			
			
    	
	</div>
</div>

	
	
</body>
</html>