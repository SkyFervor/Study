package com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;

public class UserServiceTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

	@Test
	public void test() {
		UserService userService = (UserService) ctx.getBean("userService");
		User u = new User();
		u.setUsername("zhangsan");
		userService.add(u);
	}

}
