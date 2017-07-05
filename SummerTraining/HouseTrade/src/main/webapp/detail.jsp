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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/detail.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<title>房屋详情</title>
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
			<span class="house-detail">房屋详情</span>
		</div>
	</div>
	<!-- header END -->

	<!-- wrapper -->
	<div id="wrapper">
		<div class="content clearfix">
			<div class="leftBox">
				<div class="col-cont">
					<p style="font-size: 22px; margin-left: 30px; margin-top: 30px">${house.title}</p>
					<br /> <br />
					<div class="basic-box clearfix fang5">
						<div id="Part1">
							<div id="Part1_L">
								<div class="Part_imgCon">
									<div class="Part_ScrollCon">
										<c:forEach items="${house.houseImages}" var="houseImage">
											<c:if test="${houseImage.cover}">
												<img src="upload/${houseImage.name}" width="400" height='300' />
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="basic-info">
								<ul class="basic-info-ul">
									<li>
										<span class="fc-gray9">售价：</span>
										<b class="basic-info-price">${house.salePrice}</b>万
									</li>
									<li>
										<span class="fc-gray9">单价：</span>${house.salePrice*10000/house.houseArea}元/㎡</li>
									<li>
										<span class="fc-gray9">户型：</span>
										${house.room}室${house.hall}厅${house.bathroom}卫&nbsp;-&nbsp;${house.houseArea}㎡
									</li>
									<li>
										<span class="fc-gray9">概况：</span>
										朝${house.orientation}&nbsp;-&nbsp;${house.housingType}&nbsp;-&nbsp;${house.constructionYear}年修建
									</li>
									<li>
										<span class="fc-gray9">楼层：</span>
										${house.floor}/${house.totalFloor}
									</li>
									<li>
										<span class="fc-gray9">电梯：</span>
										<c:choose>
											<c:when test="${house.hasElevator}">有</c:when>
											<c:otherwise>无</c:otherwise>
										</c:choose>
									</li>
									<li>
										<span class="fc-gray9">小区：</span>${house.smallArea}
									</li>
									<li>
										<span class="fc-gray9">装修程度：</span>${house.decoration}
									</li>
									<li>
										<span class="fc-gray9">建筑结构：</span>${house.buildingStructure}
									</li>
									<li>
										<span class="fc-gray9">修建时间：</span>${house.constructionYear}年
									</li>
									<li>
										<span class="fc-gray9">产权：</span>${house.propertyRightType}/${house.propertyRightYear}年
									</li>
									<li>
										<span class="fc-gray9">联系人：</span>${house.person}
									</li>
									<li>
										<span class="fc-gray9">联系电话：</span>
										<b class="basic-info-price">${house.phone}</b>
									</li>
									<li>
										<span class="fc-gray9">发布者：</span>${house.user.account}
									</li>
									<li>
										<span class="fc-gray9">发布时间：</span>${house.publishTime}
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-cont">
						<div id="js-picture" class="col-cont picture">
							<div class="cont-title clearfix">
								<span class="cont-title-item">房屋描述</span>
							</div>
							<div class="cont-box pics">${house.description}</div>
						</div>
					</div>
					<div class="col-cont">
						<div id="js-picture" class="col-cont picture">
							<div class="cont-title clearfix">
								<span class="cont-title-item">房屋照片</span>
							</div>
							<div class="cont-box pics">
								<c:forEach items="${house.houseImages}" var="houseImages">
									<img src="upload/${houseImages.name}" width="800" height='600' />
								</c:forEach>
							</div>
						</div>
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