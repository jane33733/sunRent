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
	<div class="row">
		<div class="col-md-4">
			<div class="carousel slide" id="carousel-992765">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-992765">
					</li>
					<li data-slide-to="1" data-target="#carousel-992765">
					</li>
					<li data-slide-to="2" data-target="#carousel-992765">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="Carousel Bootstrap First" src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Second" src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Third" src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-992765" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-992765" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div> 
			<button type="button" class="btn btn-default">
				Default
			</button> 
			<button type="button" class="btn btn-default">
				Default
			</button> 
			<button type="button" class="btn btn-default">
				Default
			</button> 
			<button type="button" class="btn btn-default">
				Default
			</button>
		</div>
		<div class="col-md-8">
			<div class="page-header">
				<h1>
					LayoutIt! <small>Interface Builder for Bootstrap</small>
				</h1>
			</div>
			<div class="tabbable" id="tabs-161797">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-985537" data-toggle="tab">Section 1</a>
					</li>
					<li>
						<a href="#panel-408223" data-toggle="tab">Section 2</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-985537">
						<p>
							I'm in Section 1.
						</p>
					</div>
					<div class="tab-pane" id="panel-408223">
						<p>
							Howdy, I'm in Section 2.
						</p>
					</div>
				</div>
			</div>
			<p>
				Lorem ipsum dolor sit amet, <strong>consectetur adipiscing elit</strong>. Aliquam eget sapien sapien. Curabitur in metus urna. In hac habitasse platea dictumst. Phasellus eu sem sapien, sed vestibulum velit. Nam purus nibh, lacinia non faucibus et, pharetra in dolor. Sed iaculis posuere diam ut cursus. <em>Morbi commodo sodales nisi id sodales. Proin consectetur, nisi id commodo imperdiet, metus nunc consequat lectus, id bibendum diam velit et dui.</em> Proin massa magna, vulputate nec bibendum nec, posuere nec lacus. <small>Aliquam mi erat, aliquam vel luctus eu, pharetra quis elit. Nulla euismod ultrices massa, et feugiat ipsum consequat eu.</small>
			</p>
		</div>
	</div>
</div>


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
			
			<form class="form-inline">
			
				<f:bundle basename="messages">
				<label for="rg-from"><f:message key="productPrice"></f:message></label>
				</f:bundle>
				<div class="form-group">
				  <input type="number" id="priceBottom" name="rg-from" class="form-control">
				</div>
				
				<label for="rg-from"> ~ </label>
				<div class="form-group">
				  <input type="number" id="priceTop" name="rg-from" class="form-control">
				</div>
				
				<!--practice restful post-->
				<button type="button" class="btn btn-primary fr" id="searchProductByPrice" onclick="getProductByPrice()">
					顯示產品POST
				</button>
			
			</form>
		</div>
		
		<br><br>
		
    	<div class="span8">
			<!--Body content-->
			
			
			<!--查無資料-->
			<p id="no_result" style="display: none;">
				no data
			</p>
			
			<table id="product_table" class="pinkTable table-hover table" style="display: none;">
			<!--以下為固定標頭-->
			<thead>
				<tr>
				<f:bundle basename="messages">
					<!--產品編號--> 
					<th><f:message key="productId"></f:message></th>
					<!--產品名稱--> 
					<th><f:message key="productName"></f:message></th>
					<!--價格--> 
					<th><f:message key="productPrice"></f:message></th>
					<!--時間--> 
					<th><f:message key="createTime"></f:message></th>
					<!--查看-->
					<th><f:message key="detail"></f:message></th>
		        </f:bundle>
				</tr>
			</thead>
			
			<tbody id="product_tbody">
			<!--顯示資料庫資料-->
			</tbody>
				
			</table>
			
			
    	</div>
	</div>
</div>

	
	
</body>
</html>