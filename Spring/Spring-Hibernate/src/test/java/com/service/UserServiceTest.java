package com.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;

public class UserServiceTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		User u = new User();
		u.setUsername("张三");
		userService.add(u);
		ctx.close();
	}
}
