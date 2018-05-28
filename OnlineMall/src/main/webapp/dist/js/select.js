//查询商品功能
$(function(){
	//根据商品id查询商品
	$("#selectId").click(selectGoods);
});
function selectGoods(){
	var name = $("#textt").val();
	$.ajax({
		url:"good/doSelectGood.do",
		type:"post",
		data:{"name":name},
		success:function(result){
			if(result.state==1){
				setCookie("name",name,1);
				location.href = "pc.html";
			}else{
				location.href = "loginUI.do";
			}
		}
	})
	
}