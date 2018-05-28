$(function(){
	doGetObjects();
	$(".paginList")
	.on("click",".first,.pre,.next,.last",doJumpToPage)
	
	$(".yg-add").on("click",".btn-search",doQueryObjects)
	.on("click",".ui-xz1",doDeleteObject)
	.on("click",".ui-xz2",doUpd)
//	.on("click",".ui-xz",doLoadEditPage)
	
	
});









function doUpd(){
	var ids=doGetCheckedIds();
	if(ids.length==0){
		alert("请选择要修改的数据！");
		return;
	}else if(ids.length>1){
		alert("请选择一条数据修改")
		return;
	}
	
	var data=$("input[value="+ids[0]+"]").parents("tr").data("data");
	
	$(".yg-gl").load("addUpdUI.do",function(){
		$(".home").data("data",data);
	});
	
}

function doDeleteObject(){
	//1.获取选中的值
	var ids=doGetCheckedIds();
	//2.对值进行验证
	if(ids.length==0){
		alert("please check");
		return;
	}
	//3.异步请求执行删除
	var url = "doDeleteEmp.do";
	var params={"ids":ids};
	$.post(url,params,function(result){
		if(result.state==1){
			doGetObjects();
		}else{
			alert(result.message);
		}
	})
}

//获取选中的id值
function doGetCheckedIds(){
	var array=[];
	$("tbody input[name='checkItem']").each(function(){
		if($(this).prop("checked")){
			array.push($(this).val());
		}
	});
	return array.toString();
}


function doQueryObjects(){
	$(".pagin").data("pageCurrent",1);
	doGetObjects();
}


function doGetObjects(){
	//获取参数信息
	var pageCurrent=$(".paginList").data("pageCurrent");
	console.log(pageCurrent);
	if(!pageCurrent)pageCurrent=1;
	var params={"pageCurrent":pageCurrent};
	var name=$("#searchNameId").val();
	params.username=name;
	//发送异步请求
	$.ajax({
		url:"doFindPageEmp.do",
		dataType:"json",
		data:params,
		success:function(result){
			if(result.state==1){
				console.log(result);
				setTableBodyRows(result.data.records);
				setPagination(result.data);
			}else{
				//	$(".pagin").html(result.message);
			}
		}
	})

}

function setTableBodyRows(data){
	//1.获取body对象
	var tBody = $("#tbodyId");
	tBody.empty();
	//2.迭代data，将data添加到Body
	for(var i in data){
		var tr=$("<tr></tr>");
		tr.data("data",data[i]);
		var tds=createdTds(data[i]);
		tr.append(tds);
		tBody.append(tr)
	}


}
function createdTds(data){
//	<th scope="col">ID</th>
//	<th>员工姓名</th>
//	<th>员工密码</th>
//	<th>手机号码</th>
//	<th>邮箱</th>
//	<th>注册账号的时间</th>
//	<th>更改账号的时间</th>
	var tds = "<td><input type='checkbox' name='checkItem' class='check-btn' value='"+data.id+"'></td>"+
	"<td>"+data.username+"</td>"+
	"<td>"+data.password+"</td>"+
	"<td>"+data.phone+"</td>"+
	"<td>"+data.email+"</td>"+
	"<td>"+new Date(data.createdTime).toLocaleDateString()+"</td>"+
	"<td>"+new Date(data.updatedTime).toLocaleDateString()+"</td>";
	return tds;
}

//设置分页
function setPagination(data){
	console.log(data);
//1.初始化总页数
$(".pageCount").html("总页数("+data.pageCount+")");
//2.初始化总记录数
$(".rowCount").html("总记录数("+data.rowCount+")");
//3.初始化当前页页码
$(".pageCurrent").html("当前页("+data.pageCurrent+")");
//4.绑定数据
$(".paginList").data("pageCurrent",data.pageCurrent);
$(".paginList").data("pageCount",data.pageCount);
}
function doJumpToPage(){
//1.获取当前页码以及总页数
var pageCurrent=
$(".paginList").data("pageCurrent");
var pageCount=
$(".paginList").data("pageCount");
//2.根据当前点击的对象执行pageCurrent加减操作
var cls=$(this).prop("class");
if(cls=="pre"&&pageCurrent>1){
   pageCurrent--;
}else if(cls=="next"&&pageCurrent<pageCount){
   pageCurrent++;
}else if(cls=="first"){
   pageCurrent=1;
}else if(cls=="last"){
   pageCurrent=pageCount;
}
console.log(pageCurrent);
//3.保存当前pageCurrent的值
$(".paginList").data("pageCurrent",pageCurrent);
//4.按指定页码重新执行查询
doGetObjects();
}

















