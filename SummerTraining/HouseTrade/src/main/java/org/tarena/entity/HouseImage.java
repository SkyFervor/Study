package org.tarena.entity;

public class HouseImage {
	private int id;// 主键
	private String name;// 图片名称
	private int house_id; // 关联的房屋id
	private boolean cover; // 是否是封面

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}

}
