
function fun1()
{ 
   var username = document.getElementById("username").value;
	if(username==""){
	document.getElementById('tishi').innerHTML="用户名不能为空！";
	return false;
	}
	else if(username.length>10){
	document.getElementById('tishi').innerHTML="用户名过长，请重新输入";
	document.getElementById("username").value="";
	return false;
	}
	else {
		document.getElementById('tishi').innerHTML="";
		return true;
	}
	  
}

function fun2()
{ 
   var email = document.getElementById("email").value;
	var expr =  /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
	if(email==""){
	document.getElementById('tishi').innerHTML="邮箱地址不能为空！";
	return false;
	}

	else if(!expr.test(email)){
	document.getElementById('tishi').innerHTML="邮箱格式错误，请重新输入！";
	document.getElementById("email").value="";
	return false;
	}
	else {
		document.getElementById('tishi').innerHTML="";
		return true;
		}
	  
}

function fun3()
{ 
   var password = document.getElementById("password").value;
	if(password==""){
	document.getElementById('tishi').innerHTML="密码不能为空！";
	return false;
	}

	else if(password.length<6){
	document.getElementById('tishi').innerHTML="密码请不要少于6位数！";
	document.getElementById("password").value="";
	return false;
	}
	else {
		document.getElementById('tishi').innerHTML="";
		return true;
		}
	  
}

function fun4()
{ 
   var password1 = document.getElementById("password1").value;
var password = document.getElementById("password").value;
	if(password1==""){
	document.getElementById('tishi').innerHTML="密码不能为空！";
	return false;
	}

	else if(password!=password1){
	document.getElementById('tishi').innerHTML="两次密码不一致！";
	document.getElementById("password1").value="";
	return false;
	}
	else {
		document.getElementById('tishi').innerHTML="";
		return true;
	}
	  
}

function fun5()
{ 
   var utel = document.getElementById("utel").value;
	var expr =  /^1[3|4|5|7|8|9][0-9]\d{8}$/;
	if(utel==""){
	document.getElementById('tishi').innerHTML="手机号不能为空！";
	return false;
	}

	else if(!expr.test(utel)){
	document.getElementById('tishi').innerHTML="手机号码格式错误，请重新输入！";
	document.getElementById("utel").value="";
	return false;
	}
	else {
		document.getElementById('tishi').innerHTML="";
		return true;
		}
	  
}

function check(){
	if(fun1() && fun2() && fun3() && fun4()&& fun5()){
			alert("恭喜您，注册成功!账号为:"+" '"+document.getElementById("username").value+" '"+" "+",请牢记您的账号与密码。");
			return true;
		}
	else {
	alert("注册失败!请联系管理员");
			return false;
	}

}