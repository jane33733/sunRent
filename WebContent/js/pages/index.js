var $dataCount = 0;
var productTable = [1,2];
var character;
var productList = [];


function searchProduct(){
	jQuery.ajax({
	    url: "product/search.do",
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


	function searchSuccess(resultData){
		
		if(resultData.length > 0){
	    	
	    	productTable = resultData;
	    	
	    	function generateTable(reports){
	    		  var $table = document.createElement('table');
	    		  $table.className += "table table_admin table-bordered report_table";
	    		  $dynamicTableSpace.append($table);
	    		  generateTheadDynamic(reports.dateList, $table);
	    		  var $tbody = $table.createTBody();
	    		  reports.reportList.forEach(function (report) {
	    		    generateTBodyDynamic(report, $tbody)
	    		  });
	    		  $dynamicTableBlock.show(); // display table
	    	}

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
}


