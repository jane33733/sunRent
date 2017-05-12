var $dataCount = 0;
var productTable;
var character;
var productList = [];
var $dynamicTableBlock;
var $dynamicTableSpace;
var projectName = "janePractice/";
var lineToken = "Bearer eOKIrVkJeqRsaAWKSXvWwSbrfGb0a4qhCtfcxYspkFt";


function sendLine(){
	$("#outcome").hide();
	
	var productQueryVO = {
			message: "房客 OOO 該繳房租5423元(基本5000+電費423)"
	    };
	
	jQuery.ajax({
		beforeSend: function(request) {
		    request.setRequestHeader("Authorization", lineToken);
		},
	    url: "https://notify-api.line.me/api/notify",
	    dataType: "json",
	    data: JSON.stringify(productQueryVO),
	    type: "POST",
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

function Auth() {
    var URL = 'https://notify-bot.line.me/oauth/authorize?';
    URL += 'response_type=code';
    URL += '&client_id=你的Client_id';
    URL += '&redirect_uri=http://localhost:5467/index.html';
    URL += '&scope=notify';
    URL += '&state=abcde';
    window.location.href = URL;
}



