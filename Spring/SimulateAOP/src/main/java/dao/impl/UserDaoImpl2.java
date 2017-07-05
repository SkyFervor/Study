package dao.impl;

import model.User;

// 方法二
// 继承
// 继承原类，重写对应方法来加入所需功能
public class UserDaoImpl2 extends UserDaoImpl {

	@Override
	public void save(User user) {
		super.save(user);

		System.out.println("log2");
	}
}
