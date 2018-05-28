$(function(){
	doGetObjects();
	//doGetObjects();
	$("#collgoodsId")
	.on("click","#addToCart",doAddToCart)
	.on("click","#delfromColl",doDelfromColl)
	
	$(".pagination")
	   .on("click",".first,.pre,.next,.last",doJumpToPage)
	
})

		


/***************************************************************************/

function doGetObjects(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var url = "coll/listPageGoodsByUserId.do";
	//通过.pagination属性的绑定数据取出当前页信息
	var pageCurrent = $(".pagination").data("pageCurrent");
	//如果为获取到数据，将当前页设为1
	if(!pageCurrent) pageCurrent = 1;
	var params = {user_id:user_id,
			pageCurrent:pageCurrent};
	console.log(params);
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				console.log(result.data);
				setPagination(result.data);
				createDivs(result.data.recodes);
			}else{
				alert(result.message);
			}
		}
	})
}


function doAddToCart(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var data = $(this).parents("li").data("data");
	console.log(data);
	var url = "cart/insertGoodToCart.do";
	var params = {user_id:user_id,
			good_id:data.good_id};
	console.log(params);
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				doGetObjects();
			}else{
				alert(result.message);
			}
		}
	})
}

function doDelfromColl(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var data = $(this).parents("li").data("data");
	console.log(data);
	var url = "coll/delGoodsByGoodIds.do";
	var params = {user_id:user_id,
			good_ids:data.good_id};
	console.log(params);
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				doGetObjects();
			}else{
				alert(result.message);
			}
		}
	})
}




/*****************************************************************************/

function createDivs(data){
	var ul = $("#collgoodsId");
	ul.empty();
	for(var i in data){
		var li = $("<li></li");
		li.data("data",data[i]);
		var div = createDiv(data[i]);
		li.append(div);
		ul.append(li);
	}
}

function createDiv(data){
	var div =
		"<div class='remai1'>"+
			"<div class='remai1_1'><a><img width='164' height='181' src="+data.good_imgsrc+" /></a></div>"+
			"<div class='renai1_2'><a href='#'>"+data.good_name+"</a></div>"+
			"<div class='renai1_3'><a href='#'>"+data.good_desc+"</a></div>"+
			"<div class='renai1_3'><a href='#'>价格："+data.good_price+"</a></div>"+
			"<div>&nbsp;&nbsp<button type='button' id='delfromColl'>取消收藏</button>"+
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
			"<button type='button' id='addToCart'>加入购物车</button>"+
		"</div>";
	return div;
}

function setPagination(data){
	//1.初始化总页数
	$(".pageCount").html("总页数("+data.pageCount+")");
	//2.初始化总记录数
	$(".rowCount").html("总记录数("+data.rowCount+")");
	//3.初始化当前页页码
	$(".pageCurrent").html("当前页("+data.pageCurrent+")"); 
	//4.绑定数据
	$(".pagination").data("pageCount",data.pageCount);
	$(".pagination").data("pageCurrent",data.pageCurrent);
	
}

function initPagination(){
	//1.初始化总页数
	$(".pageCount").html("总页数(0)");
	//2.初始化总记录数
	$(".rowCount").html("总记录数(0)");
	//3.初始化当前页页码
	$(".pageCurrent").html("当前页(1)"); 
}


   
function doJumpToPage(){
	var cls = $(this).prop("class");
	var pageCurrent = $(".pagination").data("pageCurrent");
	var pageCount = $(".pagination").data("pageCount");
	if((name != "")&&((cls == "pre")||(cls == "first") )&& pageCurrent == 1){
		alert("已经是首页！");
		return;
	}else if(((cls == "next")||(cls == "last"))&& pageCurrent == pageCount){
		alert("已经是尾页！");
		return;
	}else if(cls == "first"){
		//alert("first");
		pageCurrent = 1; 
	}else if(cls == "pre" && pageCurrent > 1){
		//alert("pre");
		pageCurrent--;
	}else if(cls == "next" && pageCurrent < pageCount){
		//alert("next");
		pageCurrent++;
	}else if(cls == "last"){
		//alert("last");
		pageCurrent = pageCount
	}
	$(".pagination").data("pageCurrent",pageCurrent);
	doGetObjects();
}

