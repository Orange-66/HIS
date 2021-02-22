<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="resource/image/favicon.ico" >
<link rel="Shortcut Icon" href="resource/image/favicon.ico" />

<!--[if lt IE 9]>
<script type="text/javascript" src="resource/js/lib/html5shiv.js"></script>
<script type="text/javascript" src="resource/js/lib/respond.min.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css" href="resource/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="resource/js/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/css/style.css" />

<!--[if IE 6]>
<script type="text/javascript" src="resource/js/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<!--/meta 作为公共模版分离出去-->
<title>退号</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>

<article class="page-container">
	<!-- 挂号表单 -->
	<form class="form form-horizontal">
	<!-- #一行# -->
	<div class="row cl">
<!-- 标题*患者信息查询 -->
		<label class="form-label col-xs-1 col-sm-1"><b>信息查询</b></label>
	</div>
	
	<!-- #一行# -->
	<div class="row cl">
	
<!-- 病历号 -->
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病例号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input id="caseID" name="caseID" type="text" class="input-text" value="" placeholder="在此输入病历号" onkeydown="checkKeyForInt(this.value,event)">
		</div>
		
<!-- 搜索按钮 -->
		<div class="formControls col-xs-1 col-sm-1">
			<input id="searchButton" name="searchButton" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;">
		</div>
	</div>
	

<!-- 分割线 -->
	<p class="lh-16">&nbsp;</p>
	<div class="line"></div>


	<!-- #一行# -->
	<div class="row cl">
<!-- 标题*患者信息确认 -->
		<label class="form-label col-xs-1 col-sm-1"><b>信息确认</b></label>
	</div>
		
	<!-- #一行# -->
	<div class="row cl">
	
<!-- 姓名 -->
		<label class="form-label col-xs-1 col-sm-1">姓名：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input id="name" name="name" type="text" class="input-text" value="" readonly="readonly">
		</div>
		
<!-- 身份证号 -->
		<label class="form-label col-xs-1 col-sm-1">身份证号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input id="patientID" name="patientID" type="text" class="input-text" value="" readonly="readonly">
		</div>

<!-- 家庭住址 -->
		<label class="form-label col-xs-1 col-sm-1">家庭住址：</label>
		<div class="formControls col-xs-3 col-sm-3">
			<input id="address" name="address" type="text" class="input-text" value="" readonly="readonly">
		</div>
	</div>

		
<!-- 分割线 -->
	<p class="lh-16">&nbsp;</p>
	<div class="line"></div>

	<!-- #一行# -->
	<div class="row cl">
<!-- 标题*患者挂号信息 -->
		<label class="form-label col-xs-1 col-sm-1"><b>挂号信息</b></label>
		<div class="formControls col-xs-11 col-sm-11 text-r" id="barcon" name="barcon"></div>
	</div>
	<p class="lh-16">&nbsp;</p>
	</form>
	<div style="height:220px;">
 	<table class="table table-bg table-border table-hover" id="registerList">
 		<thead>
			<tr> <th>挂号日期</th> <th>挂号午别</th> <th>看诊科室</th> <th>就诊医生</th> <th>看诊状态</th> <th>操作</th></tr>
		</thead>
		<tbody  id="registerList-body">
			<tr> <td></td> <td></td> <td></td> <td>暂无数据</td> <td></td> <td></td></tr>
		</tbody>			
	</table>
	</div>
</article>

<!-- 页面引用-->
<script type="text/javascript" src="resource/js/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="resource/js/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="resource/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="resource/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="resource/js/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<!-- 业务脚本 --> 

<script type="text/javascript">


</script>

<!-- ----------------------------合法输入限制---------------------------------- -->
<script type="text/javascript">
	//只允许输入数字
	function checkKeyForInt(value, e) {
	
		var isOK = false;
		var key = window.event ? e.keyCode : e.which;
		//不影响正常编辑键的使用(8:BackSpace;9:Tab;46:Delete;37:Left;39:Right)
		if ((key > 95 && key < 106) || //小键盘上的0到9
			(key > 47 && key < 60) || //大键盘上的0到9
		 	key == 8 || key == 9 || key == 46 || 
		 	key == 37 || key == 39){
		 	isOK = true;
		 	} 
		else{
			if (window.event){ //IE
				e.returnValue = false; //event.returnValue=false 效果相同.
			}
		  	else{
				e.preventDefault();
			}
		}
		return isOK;
	};
</script>

<script type="text/javascript">	
	var registerList = [];
	var currentPage = 1;
	
	function refreshTable(e){
		console.log(e);
		var html = "<thead><tr> <th>挂号日期</th> <th>挂号午别</th> <th>看诊科室</th> <th>就诊医生</th> <th>看诊状态</th> <th>操作</th></tr></thead><tbody  id=\"registerList-body\">";
		
		for (var i = 0; i < e.length; i++) {
			var date = new Date(e[i].createTime);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			var D = date.getDate() < 10 ? '0'+date.getDate() : date.getDate();
			
	        var currentTime = Y + M + D;
	        
			var registerState = e[i].registState == 1 ? "已挂号" : e[i].registState == 2 ? "已就诊" : e[i].registState == 3 ? "诊断完毕" : "已退号";
 			html += "<tr>" + 
			"<td>" + currentTime + "</td>" + 
			"<td>" + e[i].regType + "</td>" +
			"<td>" + e[i].depName + "</td>" + 
			"<td>" + e[i].realName + "</td>" +
			"<td>" + registerState + "</td>" +
			"<td> <input registerid=\"" + e[i].registerID + "\" regType=\"" + e[i].regType + "\" docid=\"" + e[i].docID + "\" currentTime=\"" + currentTime + "\" registState=\"" + e[i].registState + "\" id=\"cancelButton\" name=\"cancelButton\" class=\"btn btn-primary radius\" type=\"button\" value=\"&nbsp;&nbsp;退号&nbsp;&nbsp;\" onclick=\"cancel(this)\"></td>"
		+ "</tr>";

		}
		

         $("#registerList").html(html + "</tbody>"); 
	}
	
	
	$("#caseID").change(function(){
		var caseID = $("#caseID").val();

		if(caseID != "" && caseID != null && caseID != undefined){
			var data = {};
			data['caseID'] = caseID;
		
			$.ajax({
				url : "member-cancel/searchPatient",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(data),
				dataType : "json",
				type : "post",
				
				//返回结果分流
				success: function(e){
					if(e.name != null && e.name != ""){
						$("#name").val(e.name);
						$("#patientID").val(e.patientID);
						$("#address").val(e.address);
					}
					else{
						$("#name").val("");
						$("#patientID").val("");
						$("#address").val("");
						alert("查无此人！");
					}
				}
			});
		}
	});
	
	
	function cancel(e){
		var registState = e.getAttribute("registState");

 		if(registState != 1){
 			if(registState == 4){
 				alert("已进行退号,请勿重复退号!");
 			}
 			else{
 				alert("您已就诊,不可退号!");
 			}
		}
		else{
			
	        var registerID = e.getAttribute("registerID");
	        var docid = e.getAttribute("docid");
	        var currentTime = e.getAttribute("currentTime");
	        var regType = e.getAttribute("regType");
	        var caseID = $("#caseID").val();

	        var data = {};
	        //data["registerState"] = registerState;
	        data["registerID"] = registerID;
	        data["regType"] = regType;
	        data["docid"] = docid;
	        data["currentTime"] = currentTime;
	        data["caseID"] = caseID;
	        
 			$.ajax({
				url : "member-cancel/cancelRegister",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(data),
				dataType : "json",
				type : "post",
				
				//返回结果分流
				success: function(e){
					
					alert("退号成功!");
					refreshTable(e);
					goPage(1,4);
				}
			});
		}
	};
	
	$("#searchButton").click(function(){
		var caseID = $("#caseID").val();
		$("#caseID").text();
		if(caseID != "" && caseID != null && caseID != undefined){
			var data = {};
			data["caseID"] = caseID;
			
			$.ajax({
				url : "member-cancel/searchRegister",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(data),
				dataType : "json",
				type : "post",
				
				//返回结果分流
				success: function(e){
					refreshTable(e);
					goPage(1,4);
					if(e.length == 0){alert("暂无挂号记录!");}
				}
			});
		}
	  });
	
    function goPage(pno, psize) {
        var itable = document.getElementById("registerList-body");//通过ID找到表格
        var num = itable.rows.length;//表格所有行数(所有记录数)
        var totalPage = 0;//总页数
        var pageSize = psize;//每页显示行数
        //总共分几页
        var doublePage = num / pageSize;
        var intPage = parseInt(num / pageSize);
        if (doublePage > intPage) {
            totalPage = parseInt(num / pageSize) + 1;
        } else {
            totalPage = parseInt(num / pageSize);
        }
        var currentPage = pno;//当前页数
        var startRow = (currentPage - 1) * pageSize + 1;//开始显示的行  1
        var endRow = currentPage * pageSize;//结束显示的行   15
        endRow = (endRow > num) ? num : endRow;
        //遍历显示数据实现分页
        for (var i = 1; i < (num + 1); i++) {
            var irow = itable.rows[i - 1];
            if (i >= startRow && i <= endRow) {
                irow.style.display = "table-row";
            } else {
                irow.style.display = "none";
            }
        }
        var tempStr = "";
        if (currentPage > 1) {
            tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage - 1) + "," + psize + ")\"><上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>";
            tempStr += "<b>" + currentPage + "&nbsp;&nbsp;&nbsp;</b>";
        } 
        else {
            tempStr += "<上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            tempStr += "<b>" + currentPage + "&nbsp;&nbsp;&nbsp;</b>";
        }
        if (currentPage < totalPage) {
            tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage + 1) + "," + psize + ")\">下一页>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>";
        } 
        else {
            tempStr += "  下一页>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        document.getElementById("barcon").innerHTML = tempStr;
    }
</script>

</body>
</html>