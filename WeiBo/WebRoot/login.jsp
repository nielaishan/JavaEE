<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.N.entity.Person, com.N.dao.*, com.N.dao.impl.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function check(form) {
  			if(form.username.value=="" || form.password.value=="")  
            {  
                  alert("请填写完整");  
                  return false;
            }
            return true;
  		}
  	</script>
    <base href="<%=basePath%>">
    
    <title>微博登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<style type="text/css">
  @media ( min-width: 1200px ) {
  .container-custom {
    width: 1300px;
  }
}
.main {
  background: url(.\img\1233.jpg);
  padding: 60px 0 66px 0;
  border-top: 1px solid #e9e9e9;
  font-size: 12px;
}
.main .user-info {
  padding: 0 30px;
}
.main .login-part {
  background: #FFFFFF;
  border: 1px solid #eaeaea;
  border-bottom: 1px solid #cbcbcb;
  box-shazdow: 1px 1px 1px #eaeaea;
}
.main .login-part h3 {
  margin: 0;
  margin-bottom: 23px;
  font-size: 1.25em;

  padding: 32px 30px 0 30px;
}
.extends-input,
.user-name,
.pass-word {
  background: #fff;
  display: block;
  width: 100%;
  padding: 8px 0;
  border: 2px solid #e1e1e1;
  margin-bottom: 20px;
  font-weight: normal;
  text-indent: 43px;
  outline: 0;
  font-size: 1.25em;
  *line-height: 20px;
}

.extends-input, .validate-code {
    background: #fff;
    width: 40%;
    padding: 8px 0;
    border: 2px solid #e1e1e1;
    margin-bottom: 20px;
    margin-top: 20px;
    font-weight: normal;
    text-indent: 20px;
    outline: 0;
    font-size: 1.25em;
}
.code-img {
    width: 90px;
    height: 32px;
    margin-left: 10px;
}

.change-code {
    font-size: 1.1em;
    color: #ff0000;
}
.extends-input:focus,
.user-name:focus,
.pass-word:focus,
.validate-code:focus {
  border: 2px solid #d6f1ff;
}
.user-pass form {
  margin: 0;
  padding: 0;
  padding-right: 8px;
}
.user-name {
  background: no-repeat 15px center;
}
.pass-word {
  background: no-repeat 15px center;
  margin-bottom: 0;
}
.forget-password {
  margin-top: 10px;
  color: #999;
  font-size: 1em;
  *padding: 0 10px;
}
.forget-password span {
  *padding: 0;
}
.forget-password input {
  margin-right: 10px;
  border: 1px solid #ccc;
}
.forget-password a {
  color: #FFF;
  text-decoration: none;
}
.forget-password a:hover {
  text-decoration: underline;
}
.forget-password .forget {
  text-align: right;
}
.logging {
  background: #5bc0de;
  display: block;
  height: 30px;
  line-height: none;
  border-color: #2e6da4
  text-align: center;
  margin-top: 20px;
  font-size: 1.5em;
  text-decoration: none;
  clear: both;
  width: 100%;
  border: none;
}

.logging:hover {

  color: #fff;
  text-decoration: none;
}
.wrap-login {
	display: table;
	margin: 0 auto;
}
.wrap-login .login-banner {
	display: table-cell;
	vertical-align: middle;
	padding-right: 20px;
}

.wrap-login .login-user {
	float: left;
}
<!--.pub_fo {
	margin-top: 0 !important;
} -->
	</style>
  </head>
  
  <body>
    <div id="hidebg"></div>
	<div id="hidebox"><div id="close" onClick="hide();"></div><div id="wxqr" class="wxqr"></div></div>
  	<script type="text/javascript">
  		var protocol = window.location.protocol;
  		document.write('<script type="text/javascript" src="' +protocol+ '//csdnimg.cn/pubfooter/js/repoAddr2.js?v=' + Math.random() + '"></'+'script>');
	</script>
	
    <div class="header"></div>
    
    <div class="main">
      <div class="container container-custom">
        <div class="row wrap-login">
          <div class="login-banner col-sm-6 col-md-7 col-lg-7 hidden-xs"><a href="http://192.168.213.58:8080/WeiBo/login.jsp" target="_blank"><img src=.\image\1.jpg class="img-responsive"></a></div>
          <div class="login-user col-xs-12 col-sm-6 col-md-5 col-lg-5">
            <div class="login-part">
              <h3>帐号登录 </h3>
              <div class="user-info">
                <div class="user-pass">
                  <form name="form" action="PersonServlet?method=login" onsubmit="return check(this);" method="post">

                    <input id="username" name="username" tabindex="1" placeholder="输入账户" class="user-name" type="text">
                    <input id="password" name="password" tabindex="2" placeholder="输入密码" class="pass-word" type="password" autocomplete="off">

                    <div class="row forget-password">
                        <span class="col-xs-6 col-sm-6 col-md-6 col-lg-6 forget tracking-ad" data-mod="popu_26">
                        	<a href="#" tabindex="5">忘记密码</a>
                        </span>
                    </div>
                    
					<input class="logging" accesskey="l" value="登 录" tabindex="6" type="submit">  <br/><br/><br/><br/><br/><br/><br/><br/>
                    
                  </form>
                </div>
              </div>
                <div class="register-now" style="padding-bottom:10px;"><span>还没有微博帐号？</span>
	                	<a href="register.jsp" onclick="return">立即注册</a>      
               	</div>
              </div>
            </div>
          </div>
        </div>
      </div>
  </body>
</html>
