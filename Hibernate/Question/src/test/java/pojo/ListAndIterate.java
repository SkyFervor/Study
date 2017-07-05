package pojo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class ListAndIterate {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		try {
			sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

	@Test
	public void testQueryList() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		List<Category> categories = (List<Category>) session.createQuery("from Category").list();
		// 一次性取出所有对象的所有信息
		for (Category c : categories) {
			System.out.println(c.getName());
		}

		session.getTransaction().commit();
	}

	@Test
	public void testQueryIterate() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		Iterator<Topic> categories = (Iterator<Topic>) session.createQuery("from Topic")
				.iterate();
		// 只取出了所有对象的主键ID，其余信息在使用到时再一次性获取
		while (categories.hasNext()) {
			Topic c = categories.next();
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}

}
