<%@ page language="java" import="java.util.*,org.tarena.entity.Emp"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>员工列表</title>
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
						<a href="welcome.jsp">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>员工列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>账号</td>
						<td>姓名</td>
						<td>薪水</td>
						<td>年龄</td>
						<td>部门</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${emps}" var="emp">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.account}</td>
							<td>${emp.ename}</td>
							<td>${emp.salary}</td>
							<td>${emp.age}</td>
							<c:choose>
								<c:when test="${emp.dept==null}">
									<td>无</td>
								</c:when>
								<c:otherwise>
									<td>${emp.dept.dname}</td>
								</c:otherwise>
							</c:choose>
							<td>
								<a href="delete.do?id=${emp.id}">删除</a>
								<a href="toUpdate.do?id=${emp.id}">更新</a>
							</td>
						</tr>
					</c:forEach>
					<%-- 
					<%
						List<Emp> emps = (List<Emp>) request.getAttribute("emps");
					%>
					<%
						for (Emp emp : emps) {
					%>
					<tr>
						<td><%=emp.getId()%></td>
						<td><%=emp.getEname()%></td>
						<td><%=emp.getSalary()%></td>
						<td><%=emp.getAge()%></td>
						<td>
							<a href="#">删除</a>
							<a href="#">更新</a>
						</td>
					</tr>
					<%
						}
					%>
					 --%>
				</table>
				<p>
					<input type="button" class="button" value="添加员工"
						onclick="javascript:location.href='addEmp.jsp';" />
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>