package service;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

public class UserServiceTest {

	@Test
	public void testAdd() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService service = (UserService) ctx.getBean("userService");
		User u = new User();
		service.add(u);
		ctx.close();
	}

	@Test
	public void testScope() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		// scope="singleton"
		UserService service = (UserService) ctx.getBean("userService");
		UserService service2 = (UserService) ctx.getBean("userService");
		System.out.println(service == service2);
		System.out.println(service.getUserDao() == service2.getUserDao());

		// scope="prototype"
		UserDao userDao = (UserDaoImpl) ctx.getBean("userDao");
		UserDao userDao2 = (UserDaoImpl) ctx.getBean("userDao");
		System.out.println(userDao == userDao2);

		ctx.close();
	}

	@Test
	public void testInjection() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService service = (UserService) ctx.getBean("userService");

		// 简单属性注入
		System.out.println("daoStatus:\t" + service.getDaoStatus());
		System.out.println("daoId:\t\t" + service.getUserDao().getDaoId());

		// 集合注入
		System.out.println("list size:\t" + service.getList().size());
		System.out.println("map size:\t" + service.getMap().size());
		System.out.println("set size:\t" + service.getSet().size());

		ctx.close();
	}

	@Test
	public void testAutowire() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		// 自动装配
		UserService userService = (UserService) ctx.getBean("userService2");
		System.out.println("autowire daoId:\t" + userService.getUserDao().getDaoId());

		ctx.close();
	}

	@Test
	@SuppressWarnings("unused")
	public void testLifeCycle() {
		// 生命周期
		// singleton模式只执行一次init，只执行一次destroy
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService = (UserService) ctx.getBean("userService3");
		UserService userService2 = (UserService) ctx.getBean("userService3");
		ctx.close();

		// prototype模式没有执行destroy，因为此模式不受监控，故不要和init-method和destroy-init一起使用
		ClassPathXmlApplicationContext ctx2 = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService3 = (UserService) ctx2.getBean("userService4");
		UserService userService4 = (UserService) ctx2.getBean("userService4");
		ctx2.close();

	}

	@Test
	public void testAutoInit() {
		//创建ApplicationContext时，对于singleton的bean，创建BeanFactory时默认预初始化
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		ctx.close();

		//创建BeanFactory时，不会预初始化容器中的bean
		Resource isr = new ClassPathResource("spring-beans.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
	}
}
