package org.tarena.dao;

import org.tarena.entity.User;

public interface UserDao {
	public User findUserByAccount(String account);

	public void saveUser(User user);
}
