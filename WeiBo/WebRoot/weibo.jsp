<%@page import="com.N.dao.*, com.N.entity.*, com.N.dao.impl.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int i = 1;
int cnt = Integer.parseInt(request.getParameter("cnt"));
Weibo weibo = null;
List<Weibo>weibos = (List<Weibo>)session.getAttribute("weibos");
for (Weibo w:weibos) {
	if (i == cnt) {
		weibo = w;
		break;
	}
	i++;
} 

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人微博</title>
    
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
	<script type="text/javascript">
		function post(path, value){
			$("#weiboform").attr("action",path);
       		$("#weiboform").submit();
    	}
    
	</script>
  </head>
  
  <body>
    <div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							个人微博
						</h3>
					</div>
					<div class="panel-body" style="height:500px;width:100%">
						<form name="weiboform" id="weiboform" action="PersonServlet?method=delete" Method="post">
							<p>
								&nbsp
							</p>
							<p>
								&nbsp
							</p>
							<h3>
								<%
									out.write(weibo.getWeibo());
								 %>
							</h3>
							<p>
								&nbsp
							</p>
							<p style="float:left">
								<a href="javascript:post('PersonServlet?method=list&id=${sessionScope.user.id }&currpage=${sessionScope.pageroll.currpage }&cnt=${sessionScope.pageroll.pagecnt }')">返回</a>
								<a  href="javascript:post('PersonServlet?method=delete&id=${sessionScope.user.id}&txt=<%=weibo.getWeibo() %>')">删除</a>
							</p>
							
							
							<p style="float:right">
								<%
									out.write(weibo.getTime());
								 %>
							</p>
						</form>
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
