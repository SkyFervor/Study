package dao.impl;

import model.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
	public void save(User user) {
		System.out.println("a user saved");
	}
}
