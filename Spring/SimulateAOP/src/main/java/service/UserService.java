package service;

import model.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao;

	public void add(User user) {
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
