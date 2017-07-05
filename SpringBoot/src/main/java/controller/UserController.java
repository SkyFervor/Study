package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.User;

/**
 * @author SkyFervor
 * @date
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User hello(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		user.setName("test");
		return user;
	}

}
