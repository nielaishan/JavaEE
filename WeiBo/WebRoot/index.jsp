<%@ page language="java" import="java.util.* " pageEncoding="UTF-8" import="com.N.dao.*, com.N.entity.*, com.N.dao.impl.*"%>

<%@page import="java.util.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("user", request.getAttribute("user"));
session.setAttribute("weibos", request.getAttribute("list"));
session.setAttribute("pageroll", request.getAttribute("pageroll"));
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
	<script type="text/javascript">
		function post(path, value){
			if (value == 1) {
				$("#weiboform").attr("action",path);
	       		$("#weiboform").submit();
			}
	        else if (value == 2) {
	        	$("#friendform").attr("action", path);
	        	$("#friendform").submit();
	        }
    	}
    	function check(form) {
    		if (form.text.value == "") {
    			return false;
    		}
    		return true;
    	}
	</script>
	<title>微博首页</title>
  </head>
  
<body>
<div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						微博主页
					</h3>
				</div>
				
				<div class="panel-body" id="tabs1">
					<ul class="nav nav-tabs">
						<li class="active">
							 <a href="#panel1" data-toggle="tab">首页</a>
						</li>
						<li >
							 <a href="#panel2" data-toggle="tab">个人中心</a>
						</li>
						<li class="dropdown pull-right">
							 <a href="#" data-toggle="dropdown" class="dropdown-toggle">
							 	${requestScope.user.name }
								<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li>
									 <a href="login.jsp">退出</a>
								</li>
								
								<li class="divider">
								</li>
								<li>
									 <a href="#">帮助</a>
								</li>
							</ul>
						</li>
					</ul>
			
					<div class="tab-content">
						<div class="tab-pane active" id="panel1">
								<div  class="col-md-12 column" style="background:#FFFFFF;padding-top:10px;">
									<form name = "form" action="PersonServlet?method=addweibo&id=${requestScope.user.id }" onsubmit="return check(this);" Method="post">
										<div class="col-md-12 column" >
											<p>有什么新鲜事想告诉大家?</p>
										</div>
										<div  class="col-md-12 column" style="float:left">
											<textarea id="text" name="text" style="width:100%;height:60px"></textarea>
										</div>
										<div id="btn" class="col-md-12 column" style="padding-top:10px;">
											<input class="btn btn-warning" type="submit" style="float:right;" value="Submit"></input>
										</div>
									</form>
								</div>
								
								<div class="col-md-12 column" style="background:#FFFFFF;width:100%" >
									
									<div class="col-md-12 column" style="width:100%;" >
										<form name="weiboform" id="weiboform" action="PersonServlet?method=delete" Method="post">
											<%
												int i = 0;
										    	List<Weibo>weibos = new ArrayList<Weibo>(); 
										    	weibos = (List<Weibo>)request.getAttribute("list");
										    	for (Weibo w:weibos) {
										    		i++;
										    		out.write("<dt>"+w.getWeibo()+"</dt>");
										    		%>
										    		<p> 
										    			<a class="btn" href="weibo.jsp?cnt=<%=i %>"> View details »</a> 
										    			<a href="javascript:post('PersonServlet?method=delete&id=${requestScope.user.id}&txt=<%=w.getWeibo() %>', 1)">删除</a> 
										    		</p>
										    		
										    	<% 	
										    			out.write("<hr class='divider'></hr>");
										    		}
										   		 %>
									   	</form>
									</div>
									<div class="column-md-12 column" style="float:right">
										<form id="form1" action="PersonServlet?method=list&id=${requestScope.user.id }&currpage=1&cnt=${requestScope.pageroll.pagecnt}" Method="post">
										</form>
										<form id="form2" action="PersonServlet?method=list&id=${requestScope.user.id }&currpage=${requestScope.pageroll.currpage-1}&cnt=${requestScope.pageroll.pagecnt}" Method="post">
										</form>
										<form id="form3" action="PersonServlet?method=list&id=${requestScope.user.id }&currpage=${requestScope.pageroll.currpage+1}&cnt=${requestScope.pageroll.pagecnt}" Method="post">
										</form>
										<form id="form4" action="PersonServlet?method=list&id=${requestScope.user.id }&currpage=${requestScope.pageroll.pagecnt }&cnt=${requestScope.pageroll.pagecnt}" Method="post">
										</form>
										<input class="btn btn-primary" type="button" onclick="document.getElementById('form1').submit()" value="First"></input>
										<input class="btn btn-primary" type="button" onclick="document.getElementById('form2').submit()" value="Prev"></input>
										<input class="btn btn-primary" type="button" onclick="document.getElementById('form3').submit()" value="Next"></input>
								    	<input class="btn btn-primary" type="button" onclick="document.getElementById('form4').submit()" value="Last"></input>
										
									</div>
								</div>
						</div>
						<div class="tab-pane" id="panel2" style="height:600px">
							<div class="panel-body">
								
								 <div class="column-md-12 column" id="localImag">
								 	<img  alt="140x140" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/140/140/default.jpg" class="img-circle" />
								 </div>
								 
								 <div class="form-group">
										<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
										<p class="help-block">
											Change picture.
										</p>
								</div>
								
								<div class="column-md-12 column">
									<h3>个人信息</h3>
									<table class="table table-hover">
										<tbody>
											<tr class="success">
												<td>
													Username:
												</td>
												<td>
													${requestScope.user.name }
												</td>
												
												<td>
													Nickname:
												</td>
												<td>
													${requestScope.user.nickname }
												</td>
											
											</tr>
											<tr class="success">
												<td>
													Birthday:
												</td>
												<td>
													${requestScope.user.birthday }
												</td>
									
												<td>
													Email:
												</td>
												<td>
													${requestScope.user.email }
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="column-md-12 column">
									<a href="update.jsp" style="float:right">修改个人信息</a>
								</div>
								<div>
								<div class="column-md-12 column">
									<form id="friendform" name="friendform" action="PersonServlet?method=deletefriend" Method="post">
										<h3>好友列表</h3>
										<table class="table table-hover">
											<tbody>
												<%
													List<String>friends = new ArrayList<String>();
													friends = (List<String>) request.getAttribute("friends");
													for (String f_name:friends) {
														
												 %>
												 <tr>
												 	<td>
												 		<%=f_name %>
												 	</td>
													<td>
														<a href="javascript:post('PersonServlet?method=deletefriend&id=${requestScope.user.id}&friend=<%=f_name %>', 2)">取消关注</a>
												 	</td>
												</tr>
												<% } %>
											</tbody>
										</table>
									</form>
								</div>
								</div>
							</div>
						</div>
					</div>
			
				</div>
				<div class="panel-footer">
					<p  style="text-align:center;"> Copyright &copy; <a  class="author" href="http://blog.csdn.net/nlsqq">Jack N</a> 2017 </p>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>