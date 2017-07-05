package dao.impl;

import model.User;
import dao.UserDao;

// 想添加一个记录日志的功能
// 方法一
// 直接在源代码上加
public class UserDaoImpl implements UserDao {
	@Override
	public void save(User user) {
		System.out.println("a user saved");

		System.out.println("log1");
	}

	@Override
	public void delete(User user) {
		System.out.println("a user deleted");

		System.out.println("log1");
	}
}
