package org.tarena.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.tarena.dao.HouseDao;
import org.tarena.dao.UserDao;
import org.tarena.entity.House;
import org.tarena.entity.HouseImage;
import org.tarena.entity.User;
import org.tarena.james.extend.SearchConditionConfigLoader;

@Controller
public class HouseController {
	@Resource(name = "houseDao")
	private HouseDao houseDao;
	@Resource(name = "userDao")
	private UserDao userDao;

	// 获取所有房产信息
	@RequestMapping("/")
	public String list(HttpServletRequest request) {
		request.removeAttribute("params");

		List<House> houseList = houseDao.findAllHouse();

		request.setAttribute("houseList", houseList);
		return "forward:/list.jsp";
	}

	// 根据条件获取房产信息
	@RequestMapping("/{params}/")
	public String search(HttpServletRequest request, @PathVariable("params") String params) {
		request.setAttribute("params", params);

		String where = SearchConditionConfigLoader.getParamsSQl(params);
		List<House> houseList = houseDao.findHouseByCondition(where);

		request.setAttribute("houseList", houseList);
		return "forward:/list.jsp";
	}

	// 根据房产id获取房产信息
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));

		House house = houseDao.findHouseById(id);

		request.setAttribute("house", house);
		return "forward:/detail.jsp"; // 转发
	}

	// 发布功能在登录后才能使用，因此publish.jsp放入WEN-INF目录，只能通过转发进入
	@RequestMapping("/toPublish")
	public String toPublish(HttpServletRequest request) {
		return "forward:/WEB-INF/jsp/publish.jsp";
	}

	// 发布房产信息
	@RequestMapping("/publish")
	public String publish(HttpServletRequest request,
			@RequestParam(value = "images") MultipartFile[] uploadFiles) throws IOException {
		// 从Session中的account并获取对应User
		String account = String.valueOf(request.getSession(false).getAttribute("account"));
		User user = userDao.findUserByAccount(account);
		// 读出所有房产相关信息
		String smallArea = request.getParameter("smallArea");
		int room = Integer.parseInt(request.getParameter("room"));
		int hall = Integer.parseInt(request.getParameter("hall"));
		int bathroom = Integer.parseInt(request.getParameter("bathroom"));
		double houseArea = Double.parseDouble(request.getParameter("houseArea"));
		int totalFloor = Integer.parseInt(request.getParameter("totalFloor"));
		int floor = Integer.parseInt(request.getParameter("floor"));
		boolean hasElevator = request.getParameter("hasElevator").equals("1") ? true : false;
		String orientation = request.getParameter("orientation");
		String decoration = request.getParameter("decoration");
		String buildingStructure = request.getParameter("buildingStructure");
		String housingType = request.getParameter("housingType");
		int propertyRightYear = Integer.parseInt(request.getParameter("propertyRightYear"));
		String propertyRightType = request.getParameter("propertyRightType");
		String constructionYear = request.getParameter("constructionYear");
		BigDecimal salePrice = new BigDecimal(request.getParameter("salePrice"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String person = request.getParameter("person");
		String phone = request.getParameter("phone");
		Date publishTime = new Date(new java.util.Date().getTime());

		// 创建并设置House对象
		House house = new House();
		house.setSmallArea(smallArea);
		house.setRoom(room);
		house.setHall(hall);
		house.setBathroom(bathroom);
		house.setHouseArea(houseArea);
		house.setTotalFloor(totalFloor);
		house.setFloor(floor);
		house.setHasElevator(hasElevator);
		house.setOrientation(orientation);
		house.setDecoration(decoration);
		house.setBuildingStructure(buildingStructure);
		house.setHousingType(housingType);
		house.setPropertyRightYear(propertyRightYear);
		house.setPropertyRightType(propertyRightType);
		house.setConstructionYear(constructionYear);
		house.setSalePrice(salePrice);
		house.setTitle(title);
		house.setDescription(description);
		house.setPerson(person);
		house.setPhone(phone);
		house.setPublishTime(publishTime);
		house.setUser(user);
		// 将house写入数据库
		houseDao.saveHouse(house);

		// 保存上传的图片内容
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		for (int i = 0; i < uploadFiles.length; i++) {
			String suffix = uploadFiles[i].getOriginalFilename().substring(
					uploadFiles[i].getOriginalFilename().lastIndexOf(".")); // 取后缀
			String uploadFileName = UUID.randomUUID().toString(); // 生成UUID文件前缀
			File destFile = new File(uploadPath + "/" + uploadFileName + suffix); // 拼接文件名
			FileUtils.copyInputStreamToFile(uploadFiles[i].getInputStream(), destFile);// 输入输出流

			// 创建并设置HouseImage对象
			HouseImage houseImage = new HouseImage();
			houseImage.setName(uploadFileName + suffix);
			houseImage.setHouse_id(house.getId());
			if (i == 0) // 第一张图为封面
				houseImage.setCover(true);
			else
				houseImage.setCover(false);
			// 将houseImage写入数据库
			houseDao.saveHouseImage(houseImage);
		}

		// 转发回结果
		request.setAttribute("result", "发布成功");
		return "forward:/WEB-INF/jsp/publish.jsp";
	}
}
