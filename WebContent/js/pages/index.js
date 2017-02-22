var $dataCount = 0;
var productTable;
var character;
var productList = [];
var $dynamicTableBlock;
var $dynamicTableSpace;


function getAllProduct(){
	jQuery.ajax({
	    url: "product/getAll.do",
	    dataType: "json",
	    type: "GET",
	    contentType: 'application/json; charset=utf-8',
	    success: function(resultData){
	    	searchSuccess(resultData);
	    } ,
	    error : function(jqXHR, textStatus, errorThrown) {
	    	searchError();
	    },
	    timeout: 120000,
	});
}

function getProductByPrice(){
	var productQueryVO = {
			productId: 1,
			priceBottom: $("#priceBottom").val(),
			priceTop: $("#priceTop").val()
	    };
	
	jQuery.ajax({
		url: "product/getByPrice.do",
		data: JSON.stringify(productQueryVO),
		dataType: "json",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		success: function(resultData){
			searchSuccess(resultData);
		} ,
		error : function(jqXHR, textStatus, errorThrown) {
			searchError();
		},
		timeout: 120000,
	});
}



function searchSuccess(resultData){
	
	if(resultData.length > 0){
		
		$("#product_tbody").empty;
		dbDataTable(resultData)
		
		//顯示table
		$('#product_table').show();
		$('#no_result').hide();
		
	}else{
		searchError()
	}
}


function searchError(){
	$('#no_result').show();
	$('.book_search').hide();
}

function dbDataTable(resultData){
	var tableHtml;
	resultData.forEach(function(dbData, index){
		tableHtml = $('<tr/>');
        tableHtml.append("<td>" + dbData.id + "</td>");
        tableHtml.append("<td>" + dbData.name + "</td>");
        tableHtml.append("<td>" + dbData.price + "</td>");
        tableHtml.append("<td>" + dbData.createTime + "</td>");
        tableHtml.append("<td> </td>");
        $("#product_tbody").append(tableHtml);
	});
}




