$(function(){
	$(".box-footer").on("click",".btn-add",doSave);
	var data=$(".home").data("data");
	if(data)doInitEditFormData(data);
	debugger;
})


//初始化表单数据
function doInitEditFormData(data){
	$("#username").next().val(data.username);
	$("#password").next().val(data.password);
	$("#phone").next().val(data.phone);
	$("#email").next().val(data.email);
}




function doSave(){
	//	id,username,password,phone,email,createdTime,updatedTime
//	var id = $("#userId").next().val();
//	console.log(id);

//	var username = $("#username").next().val();
//	console.log(username);

//	var password = $("#password").next().val();
//	console.log(password);

//	var phone = $("#phone").next().val();
//	console.log(phone);

//	var email = $("#email").next().val();
//	console.log(email);
	var data=$(".home").data("data");
	var params={
			id:data.id,
			username:$("#username").next().val(),
			password:$("#password").next().val(),
			phone:$("#phone").next().val(),
			email: $("#email").next().val()	
	};
	console.log(params);
	//假如当前页面.container-fluid对象上绑定着值说明是修改
//	var data=$(".grid").data("data");
//	console.log(data);
//	if(data){
//		params.id=data.id;//修改时表单数据中需要添加id
//	}
	//根据当前页面上是否绑定着值来定义url
	var url="doUpdateEmp.do";


//	$.ajax({
//	url:"doAddEmp.do",
//	type:"post",
//	data:{"id":id,"username":username,"password":password,
//	"phone":phone,"email":email},
//	success:function(result){
//	console.log(result);
//	if(result.state==1){
//	location.href="jbxxUI.do";
//	alert("保存成功")
//	}else{
//	alert("保存失败")
//	}
//	}
//	});


	//异步提交数据
	$.post(url,params,function(result){
		if(result.state==1){
			location.href="jbxxUI.do";
			alert("save ok");
		}else{
			alert("save 不ok");
		}
	})





}
