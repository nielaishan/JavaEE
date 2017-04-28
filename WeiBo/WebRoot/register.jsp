<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<script src="./js/jquery.min.js"></script>
	<script src="./js/jquery.json.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/AjaxFileUpload.js"></script>
	<title>注册</title>
	
	<script type="text/javascript">
  		function check(form) {
  			if (form.username.value == "") {
  				alert("请输入用户名");
  				return false;
  			}
  			else if (form.nickname.value == "") {
  				alert("请输入昵称");
  				return false;
  			}
  			else if (form.password.value == "") {
  				alert("请输入密码");
  				return false;
  			}
  			else if (form.password.value != form.con_passwd.value) {
  				alert("请输入相同的密码");
  				return false;
  			}
  			return true;
  		}
  	</script>
  </head>
  
  <body>
  	<div id="hidebg"></div>
	<div id="hidebox"><div id="close" onClick="hide();"></div><div id="wxqr" class="wxqr"></div></div>
  	
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="col-md-12 column">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						微博注册
					</h3>
				</div>
				<div class="panel-body">
					<form name="form" action="PersonServlet?method=add" onsubmit="return check(this)" Method="post">
					  <div class="form-group">
					    <label for="exampleInputEmail1">username</label>
					    <input id="username" type="text" class="form-control" name="username" placeholder="username" tabindex="1">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">nickname</label>
					    <input id="nickname" type="text" class="form-control" name="nickname" placeholder="nickname" tabindex="2">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input id="password" type="password" class="form-control" name="password" placeholder="Password" tabindex="3">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Password Confirm</label>
					    <input id="con_passwd" type="password" class="form-control" name="con_passwd" placeholder="Password" tabindex="4">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Birthday</label>
					    <input id="birthday" type="text" class="form-control" name="birthday" placeholder="Birthday" tabindex="5">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Sex</label>
					    <select class="form-control" name="sex" name="sex">
					    	<option value ="male">male</option>
  							<option value ="female">female</option>
						</select>
					  </div>
					  
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					 	<input id = "email" type="email" class="form-control" id="email" placeholder="Email" name = "email" tabindex="6">   
					  </div>
					  
					  <input type="submit" class="btn btn-primary" style="float:right;" value="Submit" tabindex="7"></input>
					</form>
				</div>
				
				<div class="panel-footer">
					<p  style="text-align:center;"> Copyright &copy; <a  class="author" href="http://blog.csdn.net/nlsqq">聂莱山</a> 2017 </p>
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
