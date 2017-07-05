package org.tarena.dao;

import java.util.List;

import org.tarena.entity.House;
import org.tarena.entity.HouseImage;

public interface HouseDao {
	public List<House> findAllHouse();

	public List<House> findHouseByCondition(String where);

	public House findHouseById(int id);

	public void saveHouse(House house);

	public void saveHouseImage(HouseImage houseImage);
}
