package service;

import org.junit.Test;

import model.User;
import spring.ApplicationContext;
import spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext();

		UserService service = (UserService) factory.getBean("userService");

		User u = new User();
		service.add(u);
	}

}
