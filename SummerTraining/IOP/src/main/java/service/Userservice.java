package service;

import dao.JDBCUserDaoImpl;
import dao.UserDao;

public class Userservice {
	private UserDao userDao = new JDBCUserDaoImpl();

	public boolean login(String username, String password) {
		return false;
	}
}
