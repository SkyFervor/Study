package test.service;

import test.dao.UserDao;
import test.model.User;

public class UserServics {
	private UserDao userDao;

	public void addUser(User user) {
		userDao.save(user);
	}
}
