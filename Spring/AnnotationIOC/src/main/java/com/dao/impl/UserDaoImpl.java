package com.dao.impl;

import org.springframework.beans.factory.annotation.Required;

import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao {
	private int daoId;

	public int getDaoId() {
		return daoId;
	}

	public void save(User user) {
		System.out.println("a user saved");
	}

	// 对应属性必须在配置文件中被声明注入，否则报错
	@Required
	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}
}
