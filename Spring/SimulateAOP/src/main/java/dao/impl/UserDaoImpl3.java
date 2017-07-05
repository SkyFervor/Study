package dao.impl;

import model.User;
import dao.UserDao;

// 方法三
// 组合
// 实现原类所实现的接口，利用原类的对象来调用具体的实现
// 设计模式 - 代理模式（实质为静态代理）
public class UserDaoImpl3 implements UserDao {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		userDao.save(user);

		System.out.println("log3");
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

		System.out.println("log3");
	}
}
