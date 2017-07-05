package org.tarena.service;

import org.tarena.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean login(String username, String password) {
		return userDao.findUser(username, password);
	}
}
