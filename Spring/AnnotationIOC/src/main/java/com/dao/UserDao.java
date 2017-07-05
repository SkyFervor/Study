package com.dao;

import com.model.User;

public interface UserDao {
	public int getDaoId();

	public void save(User user);
}
