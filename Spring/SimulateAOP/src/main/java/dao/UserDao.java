package dao;

import model.User;

public interface UserDao {
	public void save(User user);

	public void delete(User user);
}
