<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ page import="com.sun.respose.vo.ProductList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:spry="http://ns.adobe.com/spry">
<head>
<jsp:include page="pages/basicPage.jsp"></jsp:include>
<script src="js/pages/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>
<body>

index try to connect java 15:09

<div class="container jane_content">
	<!-- 顯示資料 -->
	<button type="button" class="btn btn-primary fr" id="searchProduct" onclick="searchProduct()">
		顯示產品GET
	</button>
	
	<p id="no_result" style="display: none;">
	<!--Commen_null=查無資料-->
		no data
	</p>
				
	<div class="table-responsive">
		<table id="product_table" class="product_table" style="display: none;">
		<thead>
			<!--以下為固定標頭-->
			<tr>
				<!--編號--> 
				<th>編號</th>
				<!--產品名稱--> 
				<th>產品名稱</th>
				<!--價格--> 
				<th>價格</th>
				<!--時間--> 
				<th>時間</th>
				<!--查看-->
           		<th><%=LanguageUtil.getGreet()%></th>
			</tr>
		</thead>
			
		<tbody>
				<!--以下為動態資料-->
				<j:forEach items="productTable" var="product">
				   <tr>
				       <td>${product.id}</td>
				       <td>${product.name}</td>
				       <td>${product.price}</td>
				       <td>${product.creatTime}</td>
				       <td>yesy </td>
				    </tr>
				</j:forEach>
		</tbody>	
			
		</table>
	</div>
	
	<br>
	---------
	<br>
	
	
	<!-- 顯示資料 -->
	<button type="button" class="btn btn-primary fr" id="searchProductByPrice" onclick="searchProduct()">
		顯示產品POST
	</button>
	
	
	
</div>			
			
	
	
</body>
</html>