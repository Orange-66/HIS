<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>东软云医院HIS系统</title>
		<style type="text/css">
			#divForm
			{
				position: absolute;
				top: 50%;
				left: 50%;
				margin-top: -250px;
				margin-left: -150px;
			}
			#submit
			{
				 line-height:25px;
	   			 background-color: #3f81c1;
	   			 border-radius: 15px;
	   			 color: white;
    			 border: none;
   				 padding: 6px 24px;
  				 text-align: center;
   				 text-decoration: none;
   				 display: block;
   				 font-size: 14px;
   				 margin-top:15px;
   				 cursor: pointer;

			}
			
			body 
			{
				text-align:center;
				margin:0px auto;
				width:1024px;
    			background-image: url(resource/image/background.jpg);
   			 	height:100%;
				width:100%;
    			background-repeat:repeat;
    			background-size:cover;
    			color:#ffffff;
    			font-size:20px;
			}
			
			table
			{
				margin:0px auto;
			}
		</style>
		
		<script src="resource/js/jquery.min.js"></script>
		<script>
			$(function(){
				$("#submit").click(function(){
					//获取用户输入的账号密码
					var data = {};
					data['userName'] = $("#userName").val();
					data['password'] = $("#password").val();
					
					//判断账号和密码是否为空
					if(data['userName'] == null || data['userName'] == "" || data['userName'] == undefined){
					    alert("请输入账号！");
					    return;
					}
					if(data['password'] == null || data['password'] == "" || data['password'] == undefined){
					    alert("请输入密码！");
					    return;
					}
					
					$.ajax({
						url : "login/submit",
						contentType : "application/json;charset=UTF-8",
						data : JSON.stringify(data),
						dataType : "json",
						type : "post",
						
						//返回结果分流
						success: function(e){
							switch(e){
								case 0: window.location.href = 'index';
										break;
								case -1: alert("账号有误！");
										break;
								case -2: alert("密码错误！");
										break;
							}
						}
					});
				});
			});
					
		</script>
</head>
<body>
	<div id="divForm">
		<form>
			<table>
				<tr>
					<td align="center" colspan="2">
						<h2>东软云HIS系统</h2>
						<hr>			
					</td>
				</tr>
				
				<tr>
					<td align="right">账&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
					<td><input type="text" id="userName" name="userName" size="20" style="width:150px"/></td>
				</tr>
				
				<tr>
					<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td><input type="password" id="password" name="password" size="20" style="width:150px"/></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input id="submit" type="button" value="登&nbsp;&nbsp;&nbsp;陆"></input>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
