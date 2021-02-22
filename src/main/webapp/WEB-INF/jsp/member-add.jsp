<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>现场挂号</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>

<article class="page-container">

	<!-- #一行# -->
	<div class="row cl">
	
<!-- 发票号 -->
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>发票号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input id="receiptNumber" name="receiptNumber" type="text" class="input-text" value="${ receiptNumber }" readonly="readonly">
		</div>
	</div>
	
	<!-- 挂号表单 -->
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
	
<!-- 分割线 -->
		<p class="lh-16">&nbsp;</p>
		<div class="line"></div>

		<!-- #一行# -->
		<div class="row cl">
		
<!-- 标题*患者信息 -->
			<label class="form-label col-xs-1 col-sm-1"><b>患者信息</b></label>
		</div>
		
		<!-- #一行# -->	
		<div class="row cl">
		
<!-- 病历号 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input id="caseID" name="caseID" type="text" class="input-text" value="" placeholder="" onkeydown="checkKeyForInt(this.value,event)">
			</div>
			
			<!-- 新增按钮 -->
			<div class="formControls col-xs-1 col-sm-1">
				<input id="addButton" name="addButton" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;新增&nbsp;&nbsp;">
			</div>
			
			<!-- 取消按钮 -->
			<div class="formControls col-xs-1 col-sm-1">
				<input id="cancelButton" name="cancelButton" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;取消&nbsp;&nbsp;" disabled="disabled">
			</div>
		</div>
		
		
		<!-- #一行# -->	
		<div class="row cl">	
<!-- 姓名 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input id="name" name="name" type="text" class="input-text" value="" placeholder="">
			</div>

<!-- 性别 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box">
					<select class="select" id="gender" name="gender">
						<option value="71">男</option>
						<option value="72">女</option>
					</select>
				</span>
			</div>
			
<!-- 年龄 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>年龄：</label>
			<div class="formControls col-xs-1 col-sm-1">
				<input id="age" name="age" type="text" class="input-text" value="" placeholder="">
			</div>
			
<!-- 年龄单位 -->
			<div class="formControls col-xs-1 col-sm-1">
				<span class="select-box">
					<select class="select" id="ageUnit" name="ageUnit">
						<option>岁</option>
						<option>月</option>
						<option>日</option>
					</select>
				</span>
			</div>
		</div>
		
<!-- #一行# -->	
		<div class="row cl">
		
<!-- 身份证号 -->
			<label class="form-label col-xs-1 col-sm-1">身份证号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input id="patientID" name="patientID" type="text" class="input-text" value="" placeholder="在此输入身份证号" maxlength="18" onkeydown="checkKeyForCard(this.value,event)">
			</div>
			
<!-- 出生日期 -->
			<label class="form-label col-xs-1 col-sm-1">出生日期：</label>
			<div class="form-label col-xs-2 col-sm-2">
				<input name="birthday" id="birthday" type="text" class="input-text Wdate" onclick="WdatePicker({maxDate:new Date()})" style="width:190px;">
			</div>
		</div>
					
		<!-- #一行# -->	
		<div class="row cl">
<!-- 家庭住址 -->
			<label class="form-label col-xs-1 col-sm-1">家庭住址：</label>
			<div class="formControls col-xs-5 col-sm-5">
				<input id="address" name="address" type="text" class="input-text" value="" placeholder="在此输入家庭住址">
			</div>		
		</div>
		
<!-- 分割线 -->
		<p class="lh-16">&nbsp;</p>
		<div class="line"></div>
		
		<!-- #一行# -->
		<div class="row cl">
		
<!-- 标题*挂号信息 -->
			<label class="form-label col-xs-1 col-sm-1"><b>挂号信息</b></label>
			<label class="form-label col-xs-11 col-sm-11"></label>
		</div>

		<!-- #一行# -->		
		<div class="row cl">
			
<!-- 看诊日期 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>看诊日期：</label>
			<div class="form-label col-xs-2 col-sm-2">
				<input name="appointmentDate" id="appointmentDate" type="text" class="input-text Wdate" onclick="WdatePicker({minDate:new Date()})" style="width:190px;">
			</div>
			
<!-- 午别 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>午别：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" name="period" id="period">
							<option>上午</option>
							<option>下午</option>
						</select>
					</span>
			</div>
			
<!-- 挂号科室 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>挂号科室：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" name="department" id="department">
							<option value=1>心血管内科</option>
							<option value=2>神经内科</option>
							<option value=3>普通内科</option>
						</select>
					</span>
			</div>
		</div>

		<!-- #一行# -->
		<div class="row cl">
		
<!-- 号别 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>号别：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" name="doctorType" id="doctorType">
							<option value=81>普通号</option>
							<option value=83>专家号</option>
						</select>
					</span>
			</div>

<!-- 看诊医生 -->			
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>看诊医生：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" id="doctor" name="doctor">
							<option value=-1>--请选择--</option>
							<c:forEach items="${doctorList}"  var="doctor">
            					<option value="${doctor.userID}">${doctor.realName}</option>
       						</c:forEach>
						</select>
					</span>
			</div>
			
<!-- 剩余号额 -->
			<label class="form-label col-xs-1 col-sm-1">剩余号额：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input id="remain" name="remain" type="text" class="input-text" value="" placeholder="" readonly="readonly">
			</div>
		</div>
		
		<!-- #一行# -->	
		<div class="row cl">
		
<!-- 结算类别 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>结算类别：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" id="settlement" name="settlement" >
							<option value="1">自费</option>
							<option value="2">医保</option>
						</select>
					</span>
			</div>

<!-- 应收金额 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>应收金额：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input id="amount" name="amount" type="text" class="input-text" value="8" placeholder="" readonly="readonly">
			</div>

<!-- 收费方式 -->
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>收费方式：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<span class="select-box">
						<select class="select" name="chargeType" id="chargeType">
							<option value="51">现金</option>
							<option value="53">银行卡</option>
							<option value="55">微信</option>
							<option value="56">支付宝</option>
						</select>
					</span>
			</div>
		</div>
		
		
		<!-- #一行# -->
		<div class="row cl">
			
<!-- 新病历本 -->
			<label class="form-label col-xs-1 col-sm-1">新病历本：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box">
					<select class="select" id="newNote" name="newNote" >
						<option value="0">不需要</option>
						<option value="1">需要</option>
					</select>
				</span>
			</div>
		</div>

		
		<!-- #一行# -->
		<div class="row cl">
		
			<label class="form-label col-xs-3 col-sm-3"></label>
<!-- 挂号按钮 -->
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;挂号&nbsp;&nbsp;">
			</div>
			
<!-- 清空按钮 -->
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;清空&nbsp;&nbsp;">
			</div>	
		</div>
	</form>
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

<!-- -----------------------------全局变量----------------------------------- -->
<script type="text/javascript">
	var newNote = false;
	var newCase = false;
	var modifyCase = false;
	var postbirthday = "";
	var postAppointmentDate = "";
	var doctorList = [];

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
	
	//只允许输入身份证号
	function checkKeyForCard(value, e) {
	
		var isOK = false;
		var key = window.event ? e.keyCode : e.which;
		//不影响正常编辑键的使用(8:BackSpace;9:Tab;46:Delete;37:Left;39:Right)
		if ((key > 95 && key < 106) || //小键盘上的0到9
			(key > 47 && key < 60) || //大键盘上的0到9
		 	key == 8 || key == 9 || key == 46 || 
		 	key == 37 || key == 39 || key == 88){
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
	
	//是否为身份证号
	function isCardNo(card)
	{
	   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
	   var reg = /(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	   if(reg.test(card) === false)
	   {
	       alert("身份证输入不合法");
	       return  false;
	   }
	   
	   return true;
	};
</script>

<script type="text/javascript">
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#addButton").click(function(){
		
		$.ajax({
			url : "member-add/newCaseID",
			
			//返回结果分流
			success: function(e){
				newCase = true;
				modifyCase = false;
				$("#caseID").val(e);
				$("#caseID").attr("readonly","readonly");
				$("#addButton").attr("disabled","disabled");
				$("#cancelButton").removeAttr("disabled");
				
				refreshCase();
			}
		});
	  });
	
	$("#cancelButton").click(function(){
		var caseID = $("#caseID").val();
		
		var data = {};
		data['caseID'] = caseID;
	
		$.ajax({
			url : "member-add/cancelNewCaseID",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(e){
				newCase = false;
				modifyCase = false;
				$("#caseID").val("");
				$("#caseID").removeAttr("readonly");
				$("#cancelButton").attr("disabled", "disabled");
				$("#addButton").removeAttr("disabled");
				
				refreshCase();
			}
		});
	});
</script>

<!-- ----------------------------患者信息部分输入间联动-------------------------------- -->
<script type="text/javascript">
function refreshCase(){
	$("#name").val("");
	$("#gender").val("71");
	$("#age").val("");
	$("#ageUnit").val("岁");
	$("#patientID").val("");
	$("#address").val("");
}


//病历号如果存在则直接填写病人各项信息
$("#caseID").change(function(){
	var caseID = $("#caseID").val();

	if(caseID != "" && caseID != null && caseID != undefined){
		
		var data = {};
		data['caseID'] = caseID;//病历号

		$.ajax({
			url : "member-add/searchByCaseID",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
				//返回结果分流
				success: function(e){

				if(e != null){
					
					$("#name").val(e.name);//患者姓名
					$("#gender").val(e.gender);//患者性别
					$("#patientID").val(e.patientID);//患者身份证号
					
					//转换时间格式
					var timestamp = Date.parse(e.birthday);
			        var time = new Date(e.birthday);   //先将时间戳转为Date对象，然后才能使用Date的方法
			        var year = time.getFullYear();
			        var month = time.getMonth() + 1;  //月份是从0开始的
			        month = month > 9 ? month : '0' + month;
			        var day = time.getDate();
			        day = day > 9 ? day : '0' + day;
			        
			        postbirthday = year + '-' + month + '-' + day;
					$("#birthday").val(postbirthday);//患者生日
					$("#age").val(e.age);//患者年龄
					$("#ageUnit").val(e.ageUnit);//患者年龄单位
					$("#address").val(e.address);//患者家庭住址
				}
				else{
					alert("查无此人!");
				}
			}
		});
	}
});

$("#name").change(function(){
	modifyCase = true;
});

//身份证号和生日/性别年龄的联动
$("#patientID").change(function(){
	var patientID = $("#patientID").val();

	if(isCardNo(patientID)){
		//生日联动
		var birthday = patientID.substring(6,14);
		var year = birthday.substring(0,4);
		var month = birthday.substring(4,6);
		var day = birthday.substring(6,8);
		birthday = year + "-" + month + "-" + day;
		postbirthday = birthday;
		$("#birthday").val(birthday);
		
		//性别联动
		var gender = patientID.charAt(16) % 2 == 1 ? "男" : "女";
		$("#gender").val(gender);
		


		//年龄联动
		var curDate = new Date();
		birthday = new Date(birthday.replace(/-/g, "/"));
		
		var time = curDate.getTime() - birthday.getTime();
		var days = parseInt(time / (1000 * 60 * 60 * 24));
		
		var age;
		var ageUnit;

		if(days > 365){
			age = parseInt(days / 365);
			ageUnit = "岁";
		}
		else{
			if(days > 30){
				age = parseInt(days / 30);
				ageUnit = "月";
			}
			else{
				age = days;
				ageUnit = "日";
			}
		}

		$("#age").val(age);
		$("#ageUnit").val(ageUnit);
		modifyCase = true;
	}
});

//性别与身份证号联动
$("#gender").change(function(){
	
	var patientID = $("#patientID").val();
	if(patientID != "" && patientID != null && patientID != undefined){
		$("#age").val("");
		$("#birthday").val("");
	}
	$("#patientID").val("");
	modifyCase = true;
});

//生日与身份证号\年龄联动
$("#address").mouseover(function(){
	var curbirthday = $("#birthday").val();

	if(curbirthday != "" && curbirthday != null && curbirthday != undefined && curbirthday != postbirthday){
		//身份证号联动
		$("#patientID").val("");

		postbirthday = curbirthday;
		
		//年龄联动
		var curDate = new Date();
		var birthday = $("#birthday").val();
		birthday = new Date(birthday.replace(/-/g, "/"));
		var time = curDate.getTime() - birthday.getTime();
		var days = parseInt(time / (1000 * 60 * 60 * 24));
		
		var age;
		var ageUnit;

		if(days > 365){
			age = parseInt(days / 365);
			ageUnit = "岁";
		}
		else{
			if(days > 30){
				age = parseInt(days / 30);
				ageUnit = "月";
			}
			else{
				age = days;
				ageUnit = "日";
			}
		}
		
		$("#age").val(age);
		$("#ageUnit").val(ageUnit);
		modifyCase = true;
	}
});

//年龄与身份证号\生日联动
$("#age").change(function(){
	$("#patientID").val("");
	$("#birthday").val("");
	modifyCase = true;
});

//年龄单位与年龄\身份证号\生日联动
$("#ageUnit").change(function(){
	$("#patientID").val("");
	$("#age").val("");
	$("#birthday").val("");
	modifyCase = true;
  });
  
 
</script>

<!----------------------------挂号信息部分输入间联动-------------------------------->
<script type="text/javascript">

	function refreshRemain(){
		var doctor = $("#doctor").val();
		//如果此时医生的又进行过选择
		if(doctor != "-1"){
			var data = {};
			
			data['appointmentDate'] = $("#appointmentDate").val();
			data['period'] = $("#period").val();
			//data['department'] = $("#department").val();
			data['doctor'] = doctor;
			//则对剩余号额进行查找
			$.ajax({
				url : "member-add/searchRemain",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(data),
				dataType : "json",
				type : "post",
			
				//返回结果分流
				success: function(e){
					$("#remain").val(e);
				}
			});
		}
	};
	
	
	function refreshDoctor(){
		//将医生和剩余号额进行清空
		$("#remain").val("");
		
		//更新医生列表
		var data = {};
		
		data['department'] = $("#department").val();
		data['doctorType'] = $("#doctorType").val();
		//则对剩余号额进行查找
		$.ajax({
			url : "member-add/searchDoctor",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
		
			//返回结果分流
			success: function(e){
				var optionJson = e;
                var length = e.length;
                var selectObj = document.getElementById("doctor");
                selectObj.options.length = 0;
                selectObj.options.add(new Option("--请选择--",-1));
                
                for(var i = 0; i < length; i++){
                    selectObj.add(new Option(optionJson[i].realName, optionJson[i].userID));
				}
			}
		});
	};
	
	function refreshMoney(){
		var newNote = parseInt($("#newNote").val());
		var doctor = $("#doctorType").val() == "81" ? 8 : 50;

		$("#amount").val(doctor + newNote);
	};
	
	function refreshDate(){
		
		var curAppointmentDate = $("#appointmentDate").val();
		//如果当前时期和之前选择的时期是一样的则不作任何行动
		if(curAppointmentDate != "" && curAppointmentDate != null && curAppointmentDate != undefined 
		&& curAppointmentDate != postAppointmentDate){
			//反之 将当前选择的日期作为之前选择的时期
			postAppointmentDate = curAppointmentDate;

			refreshRemain();
			refreshMoney();
		}
	}

	//看诊日期与挂号信息所有联动
	$("#doctorType").mouseover(function(){
		refreshDate();
	});
	$("#chargeType").mouseover(function(){
		refreshDate();
	});
	$("#newNote").mouseover(function(){
		refreshDate();
	});
	$("#doctor").mouseover(function(){
		refreshDate();
	});

	
	//午别联动
	$("#period").change(function(){

		//如果日期有进行选择 同时 医生有进行选择
		if(postAppointmentDate != "" && postAppointmentDate != null && postAppointmentDate != undefined ){
			refreshRemain();
			refreshMoney();
		}

	});

	
	//科室联动
	$("#department").change(function(){
		refreshDoctor();
	});
	
	//号别联动
	$("#doctorType").change(function(){
		refreshDoctor();
		refreshMoney();
	});
	
	//医生联动
	$("#doctor").change(function(){
		//如果日期有进行选择 同时 医生有进行选择
		if(postAppointmentDate != "" && postAppointmentDate != null && postAppointmentDate != undefined ){
			refreshRemain();
		}
	});
	
	//新病历本联动
	$("#newNote").change(function(){
		refreshMoney();
	});
</script>

<!-- ----------------------------最终提交-------------------------------- -->
<script type="text/javascript">
	function isRepeat(){
		var data = {};
		data['caseID'] = $("#caseID").val();
		data['department'] = $("#department").val();
		data['doctor'] = $("#doctor").val();
		var e = 0;
		$.ajax({
			async: false,
			url : "member-add/isRepeat",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			type : "post",
			
			//返回结果分流
			success: function(a){
				e = a;

			}
		});
		if(e == 0){
			return false;
		}
		else{
			return true;
		}
	}

	$("#form-member-add").validate({
		rules:{
			caseID:{
				required:true,
			},
			name:{
				required:true,
			},
			age:{
				required:true,
			},
			appointmentDate:{
				required:true,
			},			
		},
		
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			if(isRepeat()){
	
				isHave();
			
			}
			else{
				alert("请勿重复挂号！");
			}
		}
	});
	
	function isHave(){
		if($("#remain").val() > 0 || $("#remain").val() != "无"){
			var data = {};
			
			//Case
			data['caseID'] = $("#caseID").val();//病历号
			if(newCase || modifyCase){
				data['name'] = $("#name").val();//患者姓名
				data['gender'] = $("#gender").val();//患者性别
				data['patientID'] = $("#patientID").val();//患者身份证号
				data['birthday'] = $("#birthday").val();//患者生日
				data['age'] = $("#age").val();//患者年龄
				data['ageUnit'] = $("#ageUnit").val();//患者年龄单位
				data['address'] = $("#address").val();//患者家庭住址
			}
			
			data['newCase'] = newCase;
			data['modifyCase'] = modifyCase;
			
			//Register
			data['appointmentDate'] = $("#appointmentDate").val();
			data['period'] = $("#period").val();
			data['department'] = $("#department").val();
			data['doctorType'] = $("#doctorType").val();
			data['doctor'] = $("#doctor").val();
			//data['remain'] = $("#remain").val();
			
			//Charge
			data['settlement'] = $("#settlement").val();
			data['amount'] = $("#amount").val();
			data['chargeType'] = $("#chargeType").val();
		    data['newNote'] = $("#newNote").val();
	
			$.ajax({
				async: false,
				url : "member-add/submit",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(data),
				dataType : "json",
				type : "post",
				
				//返回结果分流
				success: function(){
					alert("挂号成功！");
					window.location.href = 'member-add';
				}
			});
		}
		else{
			alert("今日已无号额！");
		}
	}
</script> 

</body>
</html>