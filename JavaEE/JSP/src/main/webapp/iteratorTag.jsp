<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.crazyit.org/mytaglib" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h2>带标签体的标签-迭代器标签</h2>
	<%
		List<String> a = new ArrayList<String>();
		a.add("疯狂Java");
		a.add("www.crazyit.org");
		a.add("www.fkit.org");
		pageContext.setAttribute("a", a);
	%>
	<table border="1" bgcolor="#aaaadd" width="300">
		<tag:iterator collection="a" item="item">
			<tr>
				<td>${pageScope.item }</td>
			</tr>
		</tag:iterator>
	</table>
</body>
</html>