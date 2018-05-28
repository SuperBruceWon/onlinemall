$(function(){
	$(".box-footer").on("click",".btn-add",doSave);
})


function doSave(){
//	id,username,password,phone,email,createdTime,updatedTime
	var id = $("#userId").next().val();
	console.log(id);

	var username = $("#username").next().val();
	console.log(username);

	var password = $("#password").next().val();
	console.log(password);

	var phone = $("#phone").next().val();
	console.log(phone);

	var email = $("#email").next().val();
	console.log(email);
	$.ajax({
	url:"doAddEmp.do",
	type:"post",
	data:{"id":id,"username":username,"password":password,
	"phone":phone,"email":email},
	success:function(result){
	console.log(result);
	if(result.state==1){
	location.href="jbxxUI.do";
	alert("保存成功")
	}else{
	alert("保存失败")
	}
	}
	});
}	