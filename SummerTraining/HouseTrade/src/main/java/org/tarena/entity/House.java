package org.tarena.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class House {
	private int id;// 主键
	private String smallArea;// 小区
	private int room;// 室
	private int hall;// 厅
	private int bathroom;// 卫
	private double houseArea;// 房屋面积
	private int totalFloor;// 总楼层
	private int floor;// 几楼
	private boolean hasElevator;// 是否有电梯 true有 false没有
	private String orientation;// 朝向
	private String decoration;// 装修
	private String buildingStructure;// 建筑结构
	private String housingType;// 住宅类型
	private int propertyRightYear;// 产权年限
	private String propertyRightType;// 产权类型
	private String constructionYear;// 修建时间
	private BigDecimal salePrice;// 房屋卖价
	private String title;// 房屋标题
	private String description; // 描述
	private String person; // 联系人
	private String phone; // 联系电话
	private Date publishTime;// 发布时间
	private Set<HouseImage> houseImages = new HashSet<HouseImage>();// 关联房屋图片
	private User user;// 关联的用户

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmallArea() {
		return smallArea;
	}

	public void setSmallArea(String smallArea) {
		this.smallArea = smallArea;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(double houseArea) {
		this.houseArea = houseArea;
	}

	public int getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(int totalFloor) {
		this.totalFloor = totalFloor;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isHasElevator() {
		return hasElevator;
	}

	public void setHasElevator(boolean hasElevator) {
		this.hasElevator = hasElevator;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(String buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getHousingType() {
		return housingType;
	}

	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	public int getPropertyRightYear() {
		return propertyRightYear;
	}

	public void setPropertyRightYear(int propertyRightYear) {
		this.propertyRightYear = propertyRightYear;
	}

	public String getPropertyRightType() {
		return propertyRightType;
	}

	public void setPropertyRightType(String propertyRightType) {
		this.propertyRightType = propertyRightType;
	}

	public String getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(String constructionYear) {
		this.constructionYear = constructionYear;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Set<HouseImage> getHouseImages() {
		return houseImages;
	}

	public void setHouseImages(Set<HouseImage> houseImages) {
		this.houseImages = houseImages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
