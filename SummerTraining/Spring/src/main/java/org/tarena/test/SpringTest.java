package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.UserDao;
import org.tarena.service.UserService;

public class SpringTest {
	public static void main(String[] args) {
		String config = "applicationContext.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

		UserService userService = ctx.getBean("userService", UserService.class);
		UserDao userDao = ctx.getBean("userDao", UserDao.class);

		System.out.println(userService);
		System.out.println(userDao);

		boolean result = userService.login("admin", "admin");
		System.out.println(result);
	}
}
