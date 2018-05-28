$(function(){
	doGetObjects();
	$("#delCheckedGoodsIds").click(doDelCheckedGoods)
	$("#collCheckedGoodsIds").click(doCollCheckedGoods)
	$("#checkedAllId").change(function(){
		doCheckAll($(this).prop("checked"));
	})
	$("#goodsAreaId")
	.on("click","#incGoodNumId",doIncGoodNum)
	.on("click","#decGoodNumId",doDecGoodNum)
	.on("click","#moveToCollId",doMoveToColl)
	.on("click","#delGoodsId",doDelGoods)
	.on("click","#cBox",doChangeCheckAllState)
	.on("click","#cBox",doCalTotal)
})


/*****************************************************************************/

function doGetObjects(){
	//将全选按钮的状态设置为false
	$("#checkedAllId").prop("checked",false);
	var user_id = getCookie("user_id");
	var ids = $("#goodsAreaId").data("ids");
	user_id = 1;
	var url = "cart/listGoodsByUserId.do";
	$.ajax({
		url:url,//请求路径
		data:{"user_id":user_id},//请求参数
		success:function(result){
			console.log(result.data);
			if(result.state == 1){
				createDivs(result.data);
				if(ids) initGoods(ids);
				doCalTotal();
			}else{
				alert(result.message);
			}
		}
	})
}


function doIncGoodNum(){
	var li = $(this).parents("li");
	var ids = getCheckedIds();
	var data = li.data("data");
	var num = data.good_amount;
	console.log(data)
	ids.push(data.goods_id);
	$("#goodsAreaId").data("ids",ids);
	console.log("doIncGoodNumids:"+ids);
	var params = {goods_id:data.goods_id};
	var url = "cart/incGoodsNumByGoodsId.do";
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

function doDecGoodNum(){
	var li = $(this).parents("li");
	var data = li.data("data");
	var num = data.good_amount;
	var ids = getCheckedIds();
	ids.push(data.goods_id);
	$("#goodsAreaId").data("ids",ids);
	console.log(data)
	var params = {goods_id:data.goods_id};
	var url = "cart/decGoodsNumByGoodsId.do";
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				doGetObjects();
				doCalTotal();
			}else{
				alert(result.message);
			}
		}
	})
}

function doMoveToColl(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var goods_id = new Array();
	var li = $(this).parents("li");
	var data = li.data("data");
	goods_id.push(data.goods_id);
	var ids = getCheckedIds();
	$("#goodsAreaId").data("ids",ids);
	console.log(data)
	var params = {user_id:user_id,
			goods_ids:goods_id.toString()};
	console.log(params);
	var url = "coll/insertGoodsToColl.do";
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				doGetObjects();
				doCalTotal();
			}else{
				alert(result.message);
			}
		}
	})
}

function doDelGoods(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var li = $(this).parents("li");
	var data = li.data("data");
	var ids = getCheckedIds();
	$("#goodsAreaId").data("ids",ids);
	var goods_id = [];
	goods_id.push(data.goods_id);
	var params = {user_id:user_id,
			goods_ids:goods_id.toString()};
	var url = "coll/insertGoodsToColl.do";
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

function doDelCheckedGoods(){
	var ids = getCheckedIds();
	var params = {goods_ids:ids.toString()};
	var url = "cart/delGoodsByGoodsIds.do";
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

function doCollCheckedGoods(){
	//var user_id = getCookie("user_id");
	user_id = 1;
	var ids = getCheckedIds();
	var params = {user_id:user_id,
			goods_ids:ids.toString()};
	var url = "coll/insertGoodsToColl.do";
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

//根据全选复选框的状态改变当前页面中所有复选框的状态
function doCheckAll(state){
	$("div input[name='checkItem']")
	.prop("checked",state);
	doCalTotal();
}

/*当tbody中全选元素的状态发生改变后，修改tbody中全选元素的状态值*/
function doChangeCheckAllState(){
	//设置默认值
	var flag = true;
	//迭代所有tbody中的所有的checkbox值并进行与操作
	$("div input[name='checkItem']").each(function(){
		flag = flag & $(this).prop("checked");
	});
	//修改全选元素checkbox的值为flag
	$("#checkedAllId").prop("checked",flag);
}

function doCalTotal(){
	//创建一个空数组
	var zongji = 0;
	//迭代所有选中checkbox的ID值，并加入array数组中
	$("div input[name='checkItem']").each(function(){
		if($(this).prop("checked")){
			var data = $(this).parents("li").data("data");
			zongji = zongji + data.good_price*data.good_amount;
			console.log(zongji);
		}
	});
	$("#zongji").val(zongji);
}

/******************************************************************************/

function createDivs(data){
	var ul = $("#goodsAreaId");
	ul.empty();
	for(var i in data){
		var li = $("<li></li>");
		li.data("data",data[i]);
		var div = createDiv(data[i]);
		li.append(div);
		ul.append(li);
	}
}


function createDiv(data){
	var div = 
				"<div class='zyt cen'>"+
				"<div class='input1 fl'>"+
					"<input type='checkbox' name='checkItem' value='"+data.goods_id+"' id='cBox'>"+
				"</div>"+
				"<div class='zyti fl'>"+
					"<ul>"+
					    "<li class='a fl'><a><img width='80' height='90' src="+data.good_imgsrc+"></a></li>"+
					    "<li class='b fl'><a>"+data.good_name+"</a></li>"+
					"</ul>"+
				"</div>"+
				"<div class='zytm fl'>"+
					"<div class='on'>"+data.good_desc+"</div>"+
				"</div>"+
				"<div class='zytn fl'>"+
					"<div class='fi' id='goodPrice'>"+data.good_price+"</div>"+
				"</div>"+
				"<div class='zyto fl'>"+
					"<div class='z1 fl' id='decGoodNumId'>-</div>"+
					"<input type='text' id='goodAmount' value='"+data.good_amount+"' readonly='true' class='z2 fl '>"+
					"<div class='z3 fl' id='incGoodNumId'>+</div>"+
				"</div>"+
				"<div class='zytp fl'>"+
					"<input type='text' value="+data.good_price*data.good_amount+" id='danji'>"+
				"</div>"+
				"<div class='zytq fl'>"+
					"<div class='z5' id='delGoodsId'>删除</div>"+
					"<div class='z6'><a id='moveToCollId'> 移到我的收藏</a></div>"+
				"</div>"+
			"</div>";
	return div;
}


function incGoodsNum(t,id,num){
	num = num+1;
	var input = t.parents("li").children(".goodAmount");
	if(input)  console.log(1);
	console.log(num);
}



/*获取所有选中checkbox的ID值*/
function getCheckedIds(){
	//创建一个空数组
	var array = [];
	//迭代所有选中checkbox的ID值，并加入array数组中
	$("div input[name='checkItem']").each(function(){
		if($(this).prop("checked")){
			array.push($(this).val());
		}
	});
	//返回值
	return array;
}

function initGoods(ids){
	for(var i in ids){
		$("div input[value='"+ids[i]+"']").prop("checked",true);
	}
}


