<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/register.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<title>用户注册</title>
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
			<span class="logo-tit user-reg">注册会员</span>
		</div>
	</div>
	<!-- header END -->

	<!-- wrapper -->
	<div id="wrapper">
		<div class="clearfix reg-cont V5">
			<p class="desc">注册赶集只需10秒，发布、管理信息更轻松</p>
			<div class="cont-box1">
				<div class="error-box V5" id="reg_error" style="display: none">
					<span class="validatorMsg validatorError" id="reg_error_content"></span>
				</div>
				<form action="register" method="post" id="registerform">
					<div class="field clearfix">
						<label class="field-tit" for="username">用户名：</label>
						<input name="account" class="input-text" type="text">
						<span class="msg-box" id="tip_username"></span>
					</div>
					<div class="field clearfix">
						<label class="field-tit" for="password">密码：</label>
						<input value="" name="password" class="input-text" maxlength="16" type="password">
					</div>
					<c:choose>
						<c:when test="${'-1' eq result}">
							<div class="field clearfix">
								<label class="field-tit" for="password"></label> <label
									style="color: red; float: left; font-size: 14px;">账号已被注册</label>
								<span id="tip_password"></span>
							</div>
						</c:when>
						<c:when test="${'1' eq result}">
							<div class="field clearfix">
								<script type="text/javascript">
									alert("注册成功");
									window.location.href = "login.jsp";
								</script>
							</div>
						</c:when>
					</c:choose>
					<div class="submit-box">
						<input class="btn-org" value="立即注册" type="submit">
					</div>
				</form>
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