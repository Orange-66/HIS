<!--_meta 作为公共模版分离出去-->
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
<style type="text/css">
	.page-container{
		padding-top : 0px;
		padding-left : 0px
	}
	
	#prescriptionTitle{
		margin-top:-5px;
		margin-bottom:0px;
	}
	
	#prescriptionList{
		margin-top:3px;
	}
	
	
</style>
<title>医生</title>
</head>
<body>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div id="tab-system" class="HuiTab">
			<div class="tabBar cl">
				<span>病历首页</span>
				<span>检查申请</span>
				<span>检验申请</span>
				<span>门诊确诊</span>
				<span>处置申请</span>
				<span>成药处方</span>
				<span>草药处方</span>
				<span>费用查询</span>
			</div>
				
				
			<div class="tabCon">				
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>主诉：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text radius" value="" placeholder="主诉..." id="mainSuit" name="mainSuit">
					</div>
					<br></br>
					
				 	<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>病历：</label>
					<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px">
						<textarea id="HPI" name="HPI" class="textarea radius"  style="overflow:auto;height:90px;" placeholder="患者病历信息..." spellcheck="false"></textarea>
					</div>
					<br></br>
					
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>现病治疗情况：</label>
					<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px">
						<textarea id="SHP" name="SHP" class="textarea radius"  style="overflow:auto;height:90px;" placeholder="患者治疗情况..." spellcheck="false"></textarea>
					</div>
					<br></br>
					
					<label class="form-label col-xs-4 col-sm-2">既往史：</label>
					<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px">
						<input type="text"  class="input-text radius" value="" placeholder="无" id="PS" name="PS">
					</div>
					<br></br>
					
					<label class="form-label col-xs-4 col-sm-2">过敏史：</label>
					<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px">
						<input type="text"  class="input-text radius" value="" placeholder="无" id="allergies" name="allergies">
					</div>
					<br></br>
					
					<label class="form-label col-xs-4 col-sm-2">体格检查：</label>
					<div class="formControls col-xs-8 col-sm-9" style="margin-bottom:15px">
						<input type="text"  class="input-text radius" value="" placeholder="无" id="examination" name="examination">
					</div>
					<br></br>
				</div>
				
				<div class="row cl">
					<label class="form-label col-xs-3 col-sm-3"></label>
					<div class="formControls col-xs-2 col-sm-2">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
					</div>
					<div class="formControls col-xs-2 col-sm-2">
						<input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
					</div>
				</div>
			</div>
			
				
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">检查申请：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">检验申请：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">门诊确诊：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">处置申请：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			<div class="tabCon">
				<table class="table table-border table-bordered">
					<tr>
						<!--项目搜索窗口 -->
						<td style="width:390px" class="va-t" >
							<span class="select-box" style="width:65px">
								<select class="select" name="searchType" id="searchType">
									<option value=1>药物</option>
									<option value=2>模板</option>
								</select>
							</span>
							<input type="text"  class="input-text" value="" id="searchText" name="searchText" style="width:245px">
							<input id="searchButton" name="searchButton" class="btn btn-primary radius" type="button" value="&nbsp;搜索&nbsp;" style="width:70px" onClick="search()">
						</td>
						<!-- 处方窗口 -->
						<td class="va" rowspan="2" >
							<h4 class="text-c" id="prescriptionTitle"><b>患者处方明细</b></h4>
							<div class="line"></div>
							<div style="height:390px; overflow:auto;margin-top:5px;" >
				    			<table id="prescriptionList" class="table table-bg table-border table-hover">
						    		<thead>
						    			<tr><th>药物名称</th><th>规格</th><th>单位</th><th>用法</th><th>单价</th><th>数量</th></tr>
						    		</thead>
			  						<tbody>
										<tr><td></td><td></td><td>暂无处方</td><td></td><td></td><td></td></tr>
						    		</tbody>
						    	</table>
						    </div>
						    <div class="text-r">
								<input id="saveButton" name="saveButton" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;开立&nbsp;&nbsp;" onClick="savePrescription()">
							</div>
						</td>
	
					</tr>
					<tr>
						<td>
							<div style="height:430px; overflow:auto;">
				    			<table id="itemList" class="table table-bg table-border table-hover">
						    		<thead>
						    			<tr><th>药物名称</th><th>规格</th><th>单位</th><th>用法</th><th>价格</th></tr>
						    		</thead>
			  						<tbody>
			  							<c:forEach  items="${ drugList }" var="drug" >
							    			<tr onclick="pickDrug(this)" >
							    				<td>
							    					<div class="text-overflow" style="width:120px;">${ drug.drugName }</div>
							    				</td>
							    				<td>
							    					<div class="text-overflow" style="width:50px;">${ drug.drugFormat }</div>
							    				</td>
							    				<td>${ drug.drugUnit }</td>
							    				<td>${ drug.conName }</td>
							    				<td>${ drug.price }</td>
							    			</tr>
						    			</c:forEach>
						    		</tbody>
						    	</table>
						    </div>
						</td>
					</tr>
				</table>

			</div>				
		
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">草药处方：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">费用查询：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			
			<div class="tabCon">
			</div>
			
		</div>
		

	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="resource/js/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="resource/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="resource/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="resource/js/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="resource/js/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#tab-system").Huitab({
		index:0
	});
});

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

var currentDrugList = [];
var currentPmoudleList = [];
var prescriptionList = [];

$(document).ready(function(){
		$.ajax({
			url : "system-base/getDrugList",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				currentDrugList = e;
			}
		});
	});
</script>
<!--/请在上方写此页面业务相关的脚本-->
<script type="text/javascript">

$(":input").click(function(){
	if(parent.window.registerID == ""){
		alert("请选择患者!");
		$(":input").attr("readonly","readonly");
	}
	else{
		$(":input").removeAttr("readonly");
	}

});


//searchType与展示列表联动
$("#searchType").change(function(){
	
	var patientID = $("#searchType").val();
	if(patientID == 1){
 		$.ajax({
			url : "system-base/getDrugList",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				currentDrugList = e;
				refreshDrugList(e);
			}
		});
	}
	else{
 		$.ajax({
			url : "system-base/getPmoudleList",
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				currentPmoudleList = e;
				refreshPmoudleList(e);
			}
		});
	}

});

function search(){
	
	var searchType = $("#searchType").val();//搜索类别
	var searchText = $("#searchText").val();//搜索文本
	var data = {};
	data["searchText"] = searchText;
	if(searchType == 1){
		
 		$.ajax({
			url : "system-base/searchDrug",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				currentDrugList = e;
				refreshDrugList(e);
			}
		});
	    
	}
	else{
 		$.ajax({
			url : "system-base/searchPmoudle",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				refreshPmoudleList(e);
				currentPmoudleList = e;
			}
		});
	}

};

function refreshDrugList(DrugList){
	console.log(DrugList);
	var html = "<thead>" +
					"<tr><th>药物名称</th><th>规格</th><th>单位</th><th>用法</th><th>价格</th></tr>" +
				"</thead>" +
				"<tbody>";
	
	for (var i = 0; i < DrugList.length; i++) {
		var drug = DrugList[i];
		
		html +=	"<tr onclick=\"pickDrug(this)\" >" +
					"<td>" +
						"<div class=\"text-overflow\" style=\"width:120px;\">" + drug.drugName + "</div>" +
					"</td>" +
					"<td>" +
						"<div class=\"text-overflow\" style=\"width:50px;\">" + drug.drugFormat + "</div>" +
					"</td>" +
					"<td>" + drug.drugUnit + "</td>" +
					"<td>" + drug.conName + "</td>" +
					"<td>" + drug.price + "</td>" +
				"</tr>";
	}
    $("#itemList").html(html + "</tbody>"); 
};

function refreshPmoudleList(PmoudleList){
	console.log(PmoudleList);
	var html = "<thead>" +
					"<tr><th>模板名称</th><th>范围</th></tr>" +
				"</thead>" +
				"<tbody>";
	for (var i = 0; i < PmoudleList.length; i++) {
		var pmoudle = PmoudleList[i];
		
		html +=	"<tr onclick=\"pickPmoudle(this)\" >" +
					"<td>" + pmoudle.moudleName + "</td>" +
					"<td>" + pmoudle.pRange + "</td>" +
				"</tr>";

	}
	
	$("#itemList").html(html + "</tbody>"); 
};

function refreshPrecriptionList(){
	var html = "<thead>" +
					"<tr><th>药物名称</th><th>规格</th><th>单位</th><th>用法</th><th>单价</th><th>数量</th><th>操作</th></tr>" +
				"</thead>" +
				"<tbody>";
	
	for (var i = 0; i < prescriptionList.length; i++) {
		var prescription = prescriptionList[i];
		
		html +=	"<tr>" +
			"<td>" +
				"<div class=\"text-overflow\" style=\"width:160px;\">" + prescription.drugName + "</div>" +
			"</td>" +
			"<td>" +
				"<div class=\"text-overflow\" style=\"width:50px;\">" + prescription.drugFormat + "</div>" +
			"</td>" +
			"<td>" + prescription.drugUnit + "</td>" +
			"<td>" + prescription.conName + "</td>" +
			"<td>" + prescription.price + "</td>" +
			"<td><input type=\"text\"  class=\"input-text\" value=\"" + prescription.number + "\" id=\"prescriptionNumber\" name=\"prescriptionNumber\"onchange=\"changeNumber(this)\" style=\"width:30px\" onkeydown=\"checkKeyForInt(this.value,event)\" maxlength=\"2\"></td>" +
			"<td> <input id=\"cancelButton\" name=\"cancelButton\" class=\"btn btn-danger radius\" type=\"button\" value=\"删除\" onclick=\"cancel(this)\" style=\"width:60px;\"></td>" +
		"</tr>";
	}
	$("#prescriptionList").html(html + "</tbody>"); 
};

function pickDrug(e){
	var index = e.rowIndex - 1;
	var drugItem = currentDrugList[index];
	
	drugItem.number = 1;
	
	prescriptionList.push(drugItem);
	refreshPrecriptionList();
};

function pickPmoudle(e){
	var index = e.rowIndex - 1;
	var pmoudleItem = currentPmoudleList[index];
	data = {};
	data["pPrescriptID"] = pmoudleItem.prescriptID;
	console.log(pmoudleItem);
	$.ajax({
		url : "system-base/pickPmoudle",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(data),
		dataType : "json",
		type : "post",
		
		//返回结果分流
		success: function(e){
			console.log(e);
			for(var i=0; i<e.length; i++){
				prescriptionList.push(e[i]);
				refreshPrecriptionList();
			}
		}
	});

};

function changeNumber(e){
	var index = $(e.parentNode).parent().prevAll().length;
	
	var prescriptionItem = prescriptionList[index];
	
	prescriptionItem.number = e.value;

};

function cancel(e){
	var index = $(e.parentNode).parent().prevAll().length;
	
	var frontList = prescriptionList.slice(0, index);
	var lastList = prescriptionList.slice(index + 1, prescriptionList.length);
	
	prescriptionList = frontList.concat(lastList);
	
	refreshPrecriptionList();
};

$("#form-article-add").validate({
	rules:{
		mainSuit:{
			required:true,
		},
		HPI:{
			required:true,
		},
		SHP:{
			required:true,
		},		
	},
	
	onkeyup:false,
	focusCleanup:true,
	success:"valid",
	submitHandler:function(form){
		var data = {};
		
		data['registerID'] = parent.window.registerID
		data['mainSuit'] = $("#mainSuit").val();
		data['HPI'] = $("#HPI").val();
		data['SHP'] = $("#SHP").val();
		data['PS'] = $("#PS").val();
		data['allergies'] = $("#allergies").val();
		data['examination'] = $("#examination").val();
		
 		$.ajax({
			url : "system-base/save",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				if(e == 0){
					alert("保存成功！");
					//window.location.href = 'system-base';
					parent.location.reload();
				}
				else{
					alert("保存失败！");
				}

			}
		});

	}
});


function savePrescription(){

	var data = {};

	data['registerID'] = parent.window.registerID;
	if(prescriptionList.length > 0){
		for (var i = 0; i < prescriptionList.length; i++) {  
			data["drugID[" + i + "]"] = prescriptionList[i].drugID + "";
			data["number[" + i + "]"] = prescriptionList[i].number + "";
		}
		console.log(data);
		$.ajax({
			url : "system-base/savePrescription",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				if(e == 0){
					alert("开立成功！");
					parent.location.reload();
				}
				else{
					alert("开立失败！");
				}

			}
		});
	}
	else{
		alert("请选择开立药物！");
	}
	
}
</script>
</body>
</html>
