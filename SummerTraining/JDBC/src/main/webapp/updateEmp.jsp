<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>修改员工</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
						<a href="list">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>修改员工</h1>
				<form action="update" method="post">
					<input type="hidden" name="id" value="${emp.id}" />
					<table cellpadding="0" cellspacing="0" border="0" class="form_table">
						<tr>
							<td valign="middle" align="right">id:</td>
							<td valign="middle" align="left">${emp.id}</td>
						</tr>
						<tr>
							<td valign="middle" align="right">姓名:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="ename" value="${emp.ename}" />
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">薪水:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="salary" value="${emp.salary}" />
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">年龄:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="age" value="${emp.age}" />
							</td>
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