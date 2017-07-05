package dao;

import entity.User;

public interface UserDao {
	public int save(User user);

	public User get(int id);

	public int update(User user);
}
