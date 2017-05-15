<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>

<?php
 
header('Access-Control-Allow-Origin: https://notify-api.line.me/api/notify');
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
header('Access-Control-Allow-Headers: X-Requested-With, Content-Type, Accept');
 
?>

<jsp:include page="/pages/basicPage.jsp"></jsp:include>
<script src="<c:url value='/js/pages/feature/line.js'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mail practice</title>
</head>


<body>

<input type="hidden" id="postUrl" value="<c:url value='/mail/sendEmail.do'/>"/>

<!-- 標頭 -->
<jsp:include page="/pages/top.jsp"></jsp:include>
			
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<!-- 左選單 -->
			<jsp:include page="/pages/left.jsp"></jsp:include>
		</div>
		<div class="col-md-10">
			<!-- 主內容 -->
			<h3>
				測試LINE訊息 11:14
			</h3>
			
			<br/>
			
			<!--practice restful get-->
			<button type="button" class="btn btn-primary fr" id="sendLine" onclick="sendLine()">
				Send
			</button>
			
			<br/>
			<p id="outcome">
			</p>
			
		</div>
	</div>
</div>
		
    	
	
</body>
</html>