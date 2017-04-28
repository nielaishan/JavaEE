<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<script src="./js/jquery.min.js"></script>
	<script src="./js/jquery.json.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/AjaxFileUpload.js"></script>

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
						个人信息修改
					</h3>
				</div>
				<div class="panel-body">
					<form name="form" action="PersonServlet?method=update" onsubmit="return check(this)" Method="post">
					  <div class="form-group">
					    <label for="exampleInputEmail1">username</label>
					    <input id="username" type="text" class="form-control" readonly="readonly" value = "${sessionScope.user.name}" name="username"  tabindex="1">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">nickname</label>
					    <input id="nickname" type="text" class="form-control" value = "${sessionScope.user.nickname}" name="nickname"  tabindex="2">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input id="password" type="password" class="form-control" value = "${sessionScope.user.passwd}" name="password"  tabindex="3">
					  </div>
					  
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Birthday</label>
					    <input id="birthday" type="text" class="form-control" value = "${sessionScope.user.birthday}" name="birthday" tabindex="5">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Sex</label>
					    <input id="sex" type="text" class="form-control" value = "${sessionScope.user.sex}" name="sex" tabindex="6">
					  </div>
					  
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					 	<input id = "email" type="email" class="form-control" value = "${sessionScope.user.email}" id="email" placeholder="Email" name = "email" tabindex="6">   
					  </div>
					  <input type="submit" class="btn btn-primary" style="float:left;padding-left=10px;" value="Back" tabindex="7"></input>
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
