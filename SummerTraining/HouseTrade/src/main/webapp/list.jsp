<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="james" uri="www.james.com.cn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/list.css" type="text/css" rel="stylesheet" />
<link href="css/top.css" type="text/css" rel="stylesheet" />
<title>房屋列表</title>
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
			<span class="house-list">房屋列表</span>
		</div>
		<div class="edit-eara">
			<a class="btn-post" href="toPublish" title="房屋发布" target="_blank">
				<span>房屋发布</span>
			</a>
		</div>
	</div>
	<!-- header END -->

	<!-- wrapper -->
	<div class="wraper">
		<div class="cond">
			<james:SearchCondition />
			<div class="ui-search-filter"></div>
		</div>
		<div>
			<ul class="list">
				<c:forEach items="${houseList}" var="house">
					<li style="overflow: hidden;">
						<div class="list-mod1">
							<c:forEach items="${house.houseImages}" var="houseImage">
								<c:if test="${houseImage.cover}">
									<a href="detail?id=${house.id}" target="_blank">
										<img width="160px" height="120px" src="upload/${houseImage.name}" />
									</a>
								</c:if>
							</c:forEach>
						</div>
						<div class="list-mod2">
							<div class="info-title">
								<a href="detail?id=${house.id}">${house.title}</a>
							</div>
							<div class="list-word">
								<span class="list-word-col">
									<i class="ico-general"></i>${house.smallArea}
								</span>
							</div>
							<p class="list-word">
								<span class="js-huxing">${house.room}室${house.hall}厅${house.bathroom}卫</span>
								<i class="cut-line">/</i>
								<span class="js-huxing">${house.housingType}</span>
								<i class="cut-line">/</i>
								<span class="js-huxing">${house.floor}/${house.totalFloor}层</span>
								<i class="cut-line">/</i>
								<span class="js-huxing">${house.decoration}</span>
								<i class="cut-line">/</i>
								<span class="js-huxing">${house.orientation}向</span>
								<i class="cut-line">/</i>
								<span class="js-huxing">${house.publishTime}</span>
							</p>
						</div>
						<div class="list-mod3">
							<p class="list-part list-part-first">
								<em class="sale-price">${house.salePrice}</em> 万
							</p>
							<p class="list-part">
								<span>${house.houseArea}m²</span>
								<span>
									(
									<fmt:formatNumber type="number" value="${house['salePrice']*10000/house['houseArea']}"
										maxFractionDigits="0" />
									元/m²)
								</span>
							</p>
						</div>
					</li>
				</c:forEach>
			</ul>
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
