<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>登录</title>
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="login.jsp">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>登录</h1>
				<form action="login.do" method="post">
					<table cellpadding="0" cellspacing="0" border="0" class="form_table">
						<tr>
							<td valign="middle" align="right">账号:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="account" />
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left">
								<input type="password" class="inputgri" name="password" />
							</td>
						</tr>
						<tr>
							<c:choose>
								<c:when test="${not empty result}">
									<td valign="middle" align="right"></td>
									<td valign="middle" align="left" style="color: red;">${result}</td>
								</c:when>
							</c:choose>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="确定" />
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>