package dao.impl;

import model.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
	private int daoId;

	public UserDaoImpl(int daoId) {
		this.daoId = daoId;
	}

	public int getDaoId() {
		return daoId;
	}

	public void save(User user) {
		System.out.println("a user saved");
	}
}
