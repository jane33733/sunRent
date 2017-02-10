var $impeachCheck_test, $impeach_modal, basepath;
var $impeachStartDate, $impeachEndDate, $impeachContentType, $impeachStatus,
    $impeachCharacter, $impeachKeyWorld, $book_list_render_area, $modal_impeach_area;
var $product_info;
var character;
var id = 0;
var productList = [];

function searchProduct(){
	  id = 1;

	  var url = 'product/search.do';
	  var inputData = {
	    "id": id, //傳入一個值
	  };

	  postJson(url, inputData, searchSuccess, searchError)

	  function searchSuccess(data){
	    $('#product_table').show();
	    $('#no_result').hide();
	    $book_list_render_area.empty();
	    productList = data.content;

	    if(productList.length){
	      $fragment = $(document.createDocumentFragment());
	      productList.forEach(function(book_list_data, index){
	          var book_list_item = new ClassBookList(book_list_data, index + 1);
	          book_list.push(book_list_item);
	          //append template to screen
	          $fragment.append(book_list_item.template);
	      });
	      $book_list_render_area.append($fragment);
	    }else {
	      searchError();
	    }
	  }
	  function searchError(){
	      $('#no_result').show();
	      $('.book_search').hide();
	  }
	}


