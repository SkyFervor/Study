<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/login.css" rel="stylesheet">
<title>用户登录</title>
</head>
<body>
	<!-- header -->
	<div id="header">
		<div class="head clearfix">
			<div class="city">
				<a href="">二手房交易</a>
			</div>
			<div class="head-r clearfix">
				<div class="fl reg-login">
					<span class="reg-login-btn clearfix">
						<c:choose>
							<c:when test="${not empty account}">
								<a class="login js-signin-btn" rel="nofollow" target="_self">欢迎，${account}</a>
							</c:when>
							<c:otherwise>
								<a class="reg js-signup-btn" rel="nofollow" target="_self" title="免费注册"
									href="register.jsp">免费注册</a>
								<a class="login js-signin-btn" rel="nofollow" target="_self" title="会员登录"
									href="login.jsp">会员登录</a>
							</c:otherwise>
						</c:choose>

					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="logo-wrap clearfix">
		<div class="gj-logo">
			<a href="" target="_self">
				<img width="155" height="62" src="images/0206-login-logo.png">
			</a>
		</div>
		<div class="logo-title">
			<span class="logo-tit user-login">会员登录</span>
		</div>
	</div>
	<!-- header END -->

	<!-- wrapper -->
	<div id="wrapper">
		<div class="clearfix">
			<div class="login-banner">
				<div class="bacground">
					<img src="images/login/4e99e51744d66ede0cc09.jpg" />
				</div>
			</div>
			<div class="login-box">
				<div class="cont-box1">
					<form action="login" id="loginform" method="post">
						<c:choose>
							<c:when test="${not empty result}">
								<div id="login_msg_error" class="error-box">
									<span class="validatorMsg validatorError">${result}</span>
								</div>
							</c:when>
						</c:choose>
						<div class="lh24">用户名</div>
						<div class="login_username clearfix">
							<input class="input-text usename" type="text" tabindex="1" title="用户名" name="account"
								value="">
						</div>
						<div class="lh24">密码</div>
						<div class="field clearfix">
							<input class="input-text usepassword" type="password" tabindex="2" maxlength="16"
								name="password" value="">
						</div>
						<p class="N-txt1"></p>
						<div class="submit-box">
							<input class="btn-org" type="submit" value="登录" style="display: inline;">
						</div>
					</form>
					<div class="N-box1">
						<div class="other-login"></div>
						<p class="N-txt2">
							<span>
								还没有账号，
								<a href="register.jsp">免费注册</a>
							</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- wrapper END -->

	<!-- footer -->
	<ul id="footer" class="clearfix">
		<li>
			<a target="_blank" rel="nofollow" href="#">关于</a>
			-
			<a target="_blank" rel="nofollow" href="#">推广</a>
			-
			<a target="_blank" rel="nofollow" href="#">渠道合作</a>
			-
			<a target="_blank" rel="nofollow" href="#">帮助中心</a>
			-
			<a target="_blank" rel="nofollow" href="#">手机号被冒用</a>
			-
			<a target="_blank" rel="nofollow" href="#">友情链接</a>
			-
			<a target="_blank" rel="nofollow" href="#">招贤纳士</a>
			-
			<a target="_blank" rel="nofollow" href="#">区县导航</a>
			-
			<a target="_blank" rel="nofollow" href="#">手机App</a>
			-
			<a target="_blank" rel="nofollow" href="#">触屏版</a>
		</li>
	</ul>
</body>
</html>