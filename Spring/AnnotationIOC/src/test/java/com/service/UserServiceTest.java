package com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class UserServiceTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("user-beans.xml");

	@Test
	public void testAutowire() {
		UserService service = (UserService) ctx.getBean("userService");
		System.out.println("daoId:\t" + service.getUserDao().getDaoId());
	}

	@Test
	public void testQualifier() {
		UserService service2 = (UserService) ctx.getBean("userService");
		System.out.println("daoId:\t" + service2.getUserDao2().getDaoId());
	}

	@Test
	public void testResource() {
		UserService service3 = (UserService) ctx.getBean("userService");
		System.out.println("daoId:\t" + service3.getUserDao3().getDaoId());
	}
}
