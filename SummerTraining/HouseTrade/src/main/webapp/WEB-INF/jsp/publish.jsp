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
<link href="css/publish.css" type="text/css" rel="stylesheet" />
<link href="css/top.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	var num = 1;
	function add() {
		if (num == 8)
			return;
		num++;

		$("#td_image" + num).html(
				"<br><input type='file' value='' name='images' accept='image/*' />");
	}

	function del() {
		if (num == 1)
			return;
		$("#td_image" + num).html("");
		num--;
	}
</script>
<title>房屋发布</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty result}">
			<script type="text/javascript">
				alert("发布成功！");
				window.location.href = "";
			</script>
		</c:when>
	</c:choose>
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
			<span class="house-publish">房屋发布</span>
		</div>
	</div>
	<!-- header END -->

	<!-- wrapper -->
	<div id="wrapper" class="pub">
		<div class="add-detail">

			<!-- 
			<div id="ui-uploader-1" class="ui-uploader">
				<form action="publish" method="post" enctype="multipart/form-data">
					<input type="file" name="files" />
					<br />
					<input type="submit" value="上传" />
				</form>
				<span class="ui-uploader-message" style="margin-left: 0">
					最多8张，可多选上传，最大10MB。有图可使浏览量增加3倍，并会在推荐位显示。 </span>
			</div>
			 -->

			<form id="id_post_form" action="publish" method="post" enctype="multipart/form-data">
				<input type="hidden" value="${user_id}" name="user_id" />
				<table class="nc-table" cellspacing="10" cellpadding="10" border="0">
					<tbody>
						<tr>
							<th width="100"><span class="star">*</span>小区</th>
							<td>
								<input id="id_xiaoqu" class="input-style" type="text" maxlength="20" size="40"
									name="smallArea" value=""></input>
							</td>

						</tr>

						<tr>
							<th width="100" style="text-align: top"><span class="star"> * </span> 户型</th>
							<td>
								<span class="tbl-txt">
									<input class="input-style huxing" type="text" value="" maxlength="2" name="room"
										size="2"></input>

								</span>
								<span class="tbl-txt"> 室 </span>
								<span class="tbl-txt">

									<input class="input-style huxing" type="text" value="" maxlength="2" name="hall"
										size="2"></input>

								</span>
								<span class="tbl-txt"> 厅 </span>
								<span class="tbl-txt">

									<input class="input-style huxing" type="text" value="" maxlength="2" name="bathroom"
										size="2"></input>

								</span>
								<span class="tbl-txt"> 卫 </span>
								<span class="tbl-txt">

									<input id="id_area" class="input-style huxing" type="text" value="" placeholder="面积"
										name="houseArea" size="4"></input>

								</span>
								<span class="tbl-txt"> ㎡ </span>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 楼层</th>
							<td>
								<span class="tbl-txt">
									<input class="input-style huxing" type="text" value="" maxlength="2" name="floor"
										size="2"></input>
								</span>
								<span class="tbl-txt"> 层 / 共 </span>
								<span class="tbl-txt">
									<input class="input-style huxing" type="text" value="" maxlength="2" name="totalFloor"
										size="2"></input>
								</span>
								<span class="tbl-txt"> 层 </span>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 电梯</th>
							<td class="space">
								<label> <input type="radio" value="1" name="hasElevator" /> 有

								</label> <label> <input type="radio" value="0" name="hasElevator"></input> 无

								</label>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 房屋情况</th>
							<td class="space">
								<div class="select-box">
									朝向： <select class="select-btn" name="orientation">
										<option value="东">东</option>
										<option value="南">南</option>
										<option value="西">西</option>
										<option value="北">北</option>
										<option value="南北">南北</option>
										<option value="东西">东西</option>
										<option value="东南">东南</option>
										<option value="西南">西南</option>
										<option value="东北">东北</option>
										<option value="西北">西北</option>
									</select>
								</div>
								<div class="select-box">
									装修情况： <select class="select-btn" name="decoration">
										<option value="豪华装修">豪华装修</option>
										<option value="精装修">精装修</option>
										<option value="中等装修">中等装修</option>
										<option value="简单装修">简单装修</option>
										<option value="毛坯">毛坯</option>
									</select>
								</div>
								<div class="select-box">
									建筑结构： <select class="select-btn" name="buildingStructure">
										<option value="低层板楼">低层板楼</option>
										<option value="高层板楼">高层板楼</option>
										<option value="塔楼">塔楼</option>
										<option value="板塔结合">板塔结合</option>
										<option value="其他">其他</option>
									</select>
								</div>
								<div class="select-box">
									住宅类型： <select class="select-btn" name="housingType">
										<option value="平房/四合院">平房/四合院</option>
										<option value="普通住宅">普通住宅</option>
										<option value="公寓">公寓</option>
										<option value="商住两用">商住两用</option>
										<option value="别墅">别墅</option>
										<option value="其他">其他</option>
									</select>
								</div>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 产权</th>
							<td>
								<div class="select-box">
									<select class="select-btn" name="propertyRightType">
										<option value="商品房">商品房</option>
										<option value="经济适用房">经济适用房</option>
										<option value="商住两用">商住两用</option>
										<option value="其他">其他</option>
									</select>
								</div>
								<div class="select-box">
									<select class="select-btn" name="propertyRightYear">
										<option value="70">70年</option>
										<option value="50">50年</option>
										<option value="40">40年</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 建筑年代</th>
							<td>
								<span class="tbl-txt">
									<input class="input-style" type="text" value="" name="constructionYear" size="5"></input>

								</span>
								<span class="tbl-txt"> 年 </span>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 售价</th>
							<td>
								<span class="tbl-txt">
									<input class="input-style" type="text" value="" name="salePrice" maxlength="5"
										size="5"></input>
									<br>

								</span>
								<span class="tbl-txt"> 万元 </span>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 标题</th>
							<td>
								<input id="title" class="input-style " type="text" value=""
									placeholder="吸引人的标题可让更多的人看您的信息哦" maxlength="30" size="66" name="title"></input>
							</td>

						</tr>
						<tr>

							<th width="100" valign="top"><span class="star"> * </span> 描述</th>
							<td>
								<div class="des-l">
									<textarea id="id_description" class="txtarea2"
										placeholder="房屋详细信息，小区情况，周边配套，交通情况，对租客的要求，入住时间" name="description"></textarea>
									<br>
								</div>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"></span> 上传照片</th>
							<td>
								封面：
								<input type="file" value="" name="images" accept="image/*" style="margin-left: 28px;" />
								<input type="button" value="增加图片" onclick="add()" />
								<input type="button" value="删除最后一个" onclick="del()" />
								<span id="td_image2"></span>
								<span id="td_image3"></span>
								<span id="td_image4"></span>
								<span id="td_image5"></span>
								<span id="td_image6"></span>
								<span id="td_image7"></span>
								<span id="td_image8"></span>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 联系人</th>
							<td>
								<input class="input-style" type="text" value="" name="person" size="20"></input>
							</td>

						</tr>
						<tr>

							<th width="100"><span class="star"> * </span> 联系电话</th>
							<td>
								<input id="js-phone" class="input-style" type="text" value="" name="phone" size="20"></input>
							</td>

						</tr>
					</tbody>
				</table>
				<div class="noLogin-area">
					<div id="user_iframe">
						<div class="tab-box">
							<div class="tab-tit clearfix"></div>

							<div class="submit-box">

								<input class="job-btn-org" type="submit" value="发布"></input>

							</div>
						</div>
					</div>
				</div>
			</form>
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