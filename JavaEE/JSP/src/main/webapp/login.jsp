<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/1999/xhtml">
<html>
<head>
<title>��¼</title>
</head>
<body>
	<span style="color: red; font-weight: bold">
		<%
			if (request.getAttribute("err") != null) {
				out.println(request.getAttribute("err") + "<br />");
			}
		%>
	</span>

	<form method="post" action="login">
		�û�����<input type="text" name="username" /><br />
		<br /> ��&nbsp;�룺<input type="password" name="pass" /><br />
		<br /> <input type="submit" value="��¼" />
	</form>
</body>
</html>