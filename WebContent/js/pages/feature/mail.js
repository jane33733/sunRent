var $dataCount = 0;
var productTable;
var character;
var productList = [];
var $dynamicTableBlock;
var $dynamicTableSpace;
var projectName = "janePractice/";

function sendEmail(){
	$('#outcome').hide();
	
	
	jQuery.ajax({
	    url: "/"+projectName+"mail/sendEmail.do",
	    dataType: "json",
	    type: "GET",
	    contentType: 'application/json; charset=utf-8',
	    success: function(resultData){
	    	sendSuccess(resultData);
	    } ,
	    error : function(jqXHR, textStatus, errorThrown) {
	    	sendError();
	    },
	    timeout: 120000,
	});
}


function sendSuccess(resultData){
	
	if(resultData){
		
		
		<label id="userName">名稱:</label>${userName}
		$('#outcome').val("success");
		//顯示
		$('#outcome').show();
		
	}else{
		sendError()
	}
}


function sendError(){
	$('#outcome').val("fail");
	$('#outcome').show();
}





