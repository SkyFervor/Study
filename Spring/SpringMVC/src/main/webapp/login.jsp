<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script>


$(document).keyup(function(event){  //监听回车事件 提交表单数据
	  if(event.keyCode ==13 && $("#userName").val() != "" && $("#password").val() != ""){
	    $("#submit").click();
	  }
	});
 
 
 
$(document).ready(function(){
	
	$('#submit').click(function(){
		alert($('#form').serialize());
		 $.ajax({
		        url:'<%=request.getContextPath()%>/user/login',
				type : "POST",
				data : $('#form').serialize(),
				success : function(data) {
					if(data=="success"){
						alert("登录成功");
						location.href='<%=request.getContextPath()%>'+'/index.jsp';
					} else
																alert("账号或密码错误");
														}
													});

										});

					});
</script>
</head>
<body>
	<form id="form">
		<table>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td>test</td>
				<td><input type="text" name="other.value"></td>
			</tr>
			<tr>
				<td><input type="button" value="登录" id="submit"></td>
				<td><input type="button" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>