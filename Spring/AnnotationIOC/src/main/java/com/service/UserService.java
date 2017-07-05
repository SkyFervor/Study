package com.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.dao.UserDao;
import com.model.User;

//单例模式
@Scope("singleton")
public class UserService {
	private UserDao userDao;
	private UserDao userDao2;
	private UserDao userDao3;

	public void add(User user) {
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public UserDao getUserDao2() {
		return userDao2;
	}

	public UserDao getUserDao3() {
		return userDao3;
	}

	// 自动装配
	@Autowired
	// 先按id/name查找，找不到按type查找
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	// 使用指定id/name/qualifier-value的bean进行注入
	public void setUserDao2(@Qualifier("userDao2") UserDao userDao2) {
		this.userDao2 = userDao2;
	}

	// 明确指定bean的id
	@Resource(name = "userDao3")
	public void setUserDao3(UserDao userDao3) {
		this.userDao3 = userDao3;
	}

}
