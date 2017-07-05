package test.dao;

import java.util.List;

import test.entity.User;

public interface UserDao {
	public User getUser(Integer id);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(Integer id);

	public boolean updateUser(User user);
}
