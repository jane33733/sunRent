<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/queryString.js"></script>
<script src="js/postJson.js"></script>
<script src="js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>
<body>

index try to connect java

<div class="container jane_content">
	<!-- 顯示資料 -->
	<button type="button" class="btn btn-primary fr" id="searchProduct" onclick="searchProduct()">
		顯示產品
	</button>
	
	<p id="no_result" style="display: none;">
	<!--Commen_null=查無資料-->
		no data
	</p>
				
	<div class="table-responsive">
		<table id="product_table" class="table table_admin book_search" style="display: none;">
			<!--以下為固定標頭-->
			<thead>
				<tr>
					<th></th>
					<th>
						<!--編號--> 
						編號
					</th>
					<th>
						<!--產品名稱--> 
						<%=LanguageUtil.getGreet()%>
					</th>
            				<th>
						<!--查看-->
						<%=LanguageUtil.getGreet()%>
					</th>
				</tr>
			</thead>
			
			
			<tbody>
				<!--template inject area-->
				<!--template inject area-->
			</tbody>
			
			<!--以下為動態資料-->
			<tfoot>
				<!--dynamic data -->
				<tr id="product_info" style="display: none;">
					<td><div class="index"></div></td>
            				<td><div class="bookName width180 ellipsis"></div></td>
					<td><div class="contentType width180 ellipsis"></div></td>
					<td><div class="prosecutor width180 ellipsis"></div></td>
					<td><div class="byProsecutor width180 ellipsis"></div></td>
					<td><div class="impeachTime width180 ellipsis"></div></td>
            				<td><div class="QuestionStatus width180 ellipsis"></div></td>
					<td class="width50">
						<button class="btn btn-primary btn-sm btn-block impeachCheck">
							<!--查看-->
							<%=LanguageUtil.getGreet()%>
						</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>			
			
	
	
</body>
</html>