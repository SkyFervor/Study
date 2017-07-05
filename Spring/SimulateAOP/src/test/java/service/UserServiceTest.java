package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import aop.LogInterceptor;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import spring.ApplicationContext;
import spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	/**
	 * 想添加一个记录日志的功能
	 * 方法一
	 * 直接在源代码上加
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext();

		UserService service = (UserService) factory.getBean("userService");

		service.add(new User());
	}

	/**
	 * 方法二
	 * 继承
	 * 继承原类，重写对应方法来加入所需功能
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd2() throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext();

		UserService service = (UserService) factory.getBean("userService2");

		service.add(new User());
	}

	/**
	 * 方法三
	 * 组合
	 * 实现原类所实现的接口，利用原类的对象来做具体的实现
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd3() throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext();

		UserService service = (UserService) factory.getBean("userService3");

		service.add(new User());
	}

	@Test
	public void testProxy() {
		UserDao userDao = new UserDaoImpl();
		InvocationHandler handler = new LogInterceptor(userDao);
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				userDao.getClass().getInterfaces(), handler);
		userDaoProxy.save(new User());
		userDaoProxy.delete(new User());
	}
}
