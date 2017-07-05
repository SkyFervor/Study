package com.dao.impl;

import org.springframework.stereotype.Component;

import com.dao.UserDao;
import com.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	public void save(User user) {
		System.out.println("a user saved");
	}
}
