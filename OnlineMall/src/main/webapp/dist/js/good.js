//添加商品到购物车
function doAddToCart(){
	//获取用户id，绑定cookie
	var user_id = 1;
	setCookie("user_id",user_id);
	//获取商品id
	var good_id = 1;
	var url = "cart/insertGoodToCart.do";
	var params = {user_id:user_id,
			good_id:data.good_id};
	console.log(params);
	$.ajax({
		url:url,//请求路径
		data:params,//请求参数
		success:function(result){
			if(result.state == 1){
				location.href("myCart.html");
			}else{
				alert(result.message);
			}
		}
	})
}