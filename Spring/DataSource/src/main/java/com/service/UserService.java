package com.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dao.UserDao;
import com.model.User;

@Component("userService")
@Scope("singleton")
public class UserService {
	UserDao userDao;

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		userDao.save(user);
	}
}
