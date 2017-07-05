package test.service;

import org.springframework.stereotype.Service;

import test.model.User;

@Service("userService")
public class UserService {
	public User getUser(int id) {
		User user = new User();
		user.setId(id);
		user.setUserName("zsh");
		user.setPassword("zsh");
		return user;
	}
}
