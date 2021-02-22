<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="resource/js/lib/html5shiv.js"></script>
<script type="text/javascript" src="resource/js/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="resource/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="resource/js/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="resource/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="resource/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="resource/js/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>医生诊疗</title>
</head>
<body>

<table class="table" style="margin-left:10px;width:1300px">
	<tr >
		<!-- 患者框 -->
		<td class="va-t" rowspan="2" style="width:270px">
			<ul id="Huifold1" class="Huifold">
			  <li class="item">
			    <h4>待诊患者:<b>+</b></h4>
			    <div style="height:250px; overflow:auto;">
			   		<table id="waitingQueue" class="table table-bg table-border table-hover">
			   			<thead>
			    			<tr><th>病历号</th><th>挂号</th><th>姓名</th><th>性别</th><th>年龄</th></tr>
			    		</thead>
  						<tbody>
				   			<c:if test="${ waitingQueue.size() == 0 }">
				    			<tr><td></td><td></td><td>暂无患者</td><td></td><td></td></tr>
				    		</c:if>
				    		<c:if test="${ waitingQueue.size() > 0 }">
				    			<c:forEach  items="${ waitingQueue }" var="waitingPatient" >
					    			<tr onclick="pickPatient(this)" >
					    				<td>${ waitingPatient.caseID }</td>
					    				<td>${ waitingPatient.registerID }</td>
					    				<td>${ waitingPatient.name }</td>
					    				<td>${ waitingPatient.gender == 71 ? "男" : "女" }</td>
					    				<td>${ waitingPatient.age }${ waitingPatient.ageUnit }</td>
					    			</tr>
				    			</c:forEach>
				    		</c:if>
			    		</tbody>
			    	</table>
			    </div>
			  </li>
			  <li class="item" style="margin-top:5px">
			    <h4>已诊患者:<b>+</b></h4>
			    <div style="height:250px; overflow:auto;">
			    	<table id="completionQueue" class="table table-bg table-border table-hover">
			    		<thead>
			    			<tr><th>病历号</th><th>挂号</th><th>姓名</th><th>性别</th><th>年龄</th></tr>
			    		</thead>
  						<tbody>
				    		<c:if test="${ completionQueue.size() == 0 }">
				    	   		<tr><td></td><td></td><td>暂无已诊患者</td><td></td><td></td></tr>
				    	   	</c:if>
				    	   	<c:if test="${ completionQueue.size() > 0 }">
				    			<c:forEach  items="${ completionQueue }" var="completionPatient" >
					    			<tr onclick="pickPatient(this)">
					    				<td>${ completionPatient.caseID }</td>
					    				<td>${ completionPatient.registerID }</td>
					    				<td>${ completionPatient.name }</td>
					    				<td>${ completionPatient.gender == 71 ? "男" : "女" }</td>
					    				<td>${ completionPatient.age }${ completionPatient.ageUnit }</td>
					    			</tr>
				    			</c:forEach>
				    		</c:if>
			    		</tbody>
			    	</table>
			    </div>
			  </li>
			</ul>
		</td>
		<td>
			<input class="btn btn-primary radius" type="button" value="刷新"  onClick="javascript:location.replace(location.href);">
			<b class="f-14">当前就诊患者：</b>
			<a class="f-14" id="currentPatient">无</a>
		</td>
	</tr>
	<tr>
		
	 	<!-- 病历框 -->
		<td class="va">
			<iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=550px SRC="system-base">
				
			</iframe>
		</td>
		
	</tr>
</table>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="resource/js/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="resource/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="resource/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!-- 业务脚本 -->
<script type="text/javascript">
var waitingQueue = [];
var completionQueue = [];
var registerID = "";
var that = null;

function islegal(){
		alert("请选择看诊患者!");
}

function pickPatient(e){
	//选中对象,更换样式
	if(that != null){
		that.style.backgroundColor = "#FFFFFF";
	}
	that = e;
	e.style.backgroundColor = "#ADD8E6";
	
	//获取单元格中
	var caseID = e.children[0].innerHTML;
	registerID = e.children[1].innerHTML;
	var name = e.children[2].innerHTML;
	
	//改变当前患者姓名
	$("#currentPatient").html(name);
	
	var data = {};
	data["registerID"] = registerID;

	var iframeDoc = document.getElementById('testIframe').contentWindow.document;

 	$.ajax({
		url : "doctor-category/pickPatient",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(data),
		dataType : "json",
		type : "post",
		
		success: function(e){
			console.log(e);
 			iframeDoc.getElementById("mainSuit").value = e.mainSuit;
			iframeDoc.getElementById("HPI").value = e.hpi;
			iframeDoc.getElementById("SHP").value = e.shp;
			iframeDoc.getElementById("PS").value = e.ps;
			iframeDoc.getElementById("allergies").value = e.allergies;
			iframeDoc.getElementById("examination").value = e.examination;
		}
	});
};
</script>

<!-- 组件配置 -->
<script type="text/javascript">
$(function(){
	$.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",3,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
});

jQuery.Huifold = function(obj,obj_c,speed,obj_type,Event){
	if(obj_type == 2){
		$(obj+":first").find("b").html("-");
		$(obj_c+":first").show()}
	$(obj).bind(Event,function(){
		if($(this).next().is(":visible")){
			if(obj_type == 2){
				return false}
			else{
				$(this).next().slideUp(speed).end().removeClass("selected");
				$(this).find("b").html("+")}
		}
		else{
			if(obj_type == 3){
				$(this).next().slideDown(speed).end().addClass("selected");
				$(this).find("b").html("-")}else{
				$(obj_c).slideUp(speed);
				$(obj).removeClass("selected");
				$(obj).find("b").html("+");
				$(this).next().slideDown(speed).end().addClass("selected");
				$(this).find("b").html("-")}
		}
	})};
</script>
</body>
</html>