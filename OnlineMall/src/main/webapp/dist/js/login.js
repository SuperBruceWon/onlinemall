//页面加载后
$(function(){
	//1.登录
	$("#loginId").click(Login);
	//2.注册
	$("#regId").click(register);
})
//注册
function register(){
	//获取请求参数
	var username=$("#username").val();
	//对于用户名的规范和处理
//	if(username==""){
//		$("#tishi").html=("用户名不能为空！");
//		return false;
//	}else if(username.size()>10){
//		$("#tishi").html("用户名过长，请重新输入");
//		$("#username").val("");
//		return false;
//	}else{
//		$("#tishi").html("");
//		return true;
//	}
	console.log(username);
	
	var phone=$("#utel").val();
	//对于手机号规范
//	var expr1 =  /^1[3|4|5|7|8|9][0-9]\d{8}$/;
//	if(phone==""){
//		$("#tishi").html("手机号不能为空！");
//		return false;
//	}else if(!expr1.test(phone)){
//		$("#tishi").html("手机号码格式错误，请重新输入！");
//		$("#utel").val("");
//		return false;
//	}else {
//		$("#tishi").html("");
//		return true;
//	}
	console.log(phone);
	
	var email=$("#email").val();
	//对于邮箱的规范和操作
//	var expr =  /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
//	if(email==""){
//		$("#tishi").html("邮箱地址不能为空！");
//		return false;
//	}else if(!expr.test(email)){
//		$("#tishi").html("邮箱格式错误，请重新输入！");
//		$("#email").val("");
//		return false;
//	}else {
//		$("#tishi").html("");
//		return true;
//	}
	console.log(email);
	
	
	var password=$("#password").val();
	//对于密码的规范和处理
//	if(password==""){
//		$("#tishi").html("密码不能为空！");
//		return false;
//	}else if(password.length<6){
//		$("#tishi").html("密码请不要少于6位数！");
//		$("#password").val("");
//		return false;
//	}else {
//		$("#tishi").html("");
//		return true;
//	}
	console.log(password);
	
	
	var password1=$("#password1").val();
	console.log(password1);
	//对于确认密码的规范和处理
//	if(password1==""){
//		$("#tishi").html("密码不能为空！");
//		return false;
//	}else if(password!=password1){
//		$("#tishi").html("两次密码不一致！");
//		$("password1").val("");
//		return false;
//	}else {
//		$("#tishi").html("");
//		return true;
//	}

	
	console.log(username);
	console.log(password);
	console.log(password1);
	console.log(phone);
	console.log(email);
	//发送请求
	$.ajax({
		url:"doRegister.do",
		type:"get",
		data:{"username":username,"password":password,"password1":password1,"phone":phone,"email":email},
		success:function(result){
			if(result.state==1){
//				addCookie("data",result.data,5)
				location.href="loginUI.do";
				alert("注册成功");
			}else{
				alert("注册失败");
			}
		}
	});
}
//登录
function Login(){
	//获取请求参数
	var params={
			username:$("#usernameId").val(),
			password:$("#passwordId").val()
	};

	console.log(params);
	var url="doLogin.do";
	$.post(url,params,function(result){
		if(result.state==1){
//			addCookie("userId",result.data.user_id,2);
//			addCookie("uid",user.cn_user_id,2);
//			var id = getCookie("userId");
//			console.log(id);
			location.href="indexUI.do";
		}else{
			alert("登录异常");
		}
	});


}