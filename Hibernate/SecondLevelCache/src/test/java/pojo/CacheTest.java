package pojo;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class CacheTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClassss() {
		sf = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

	@Test
	public void testSessionCache() {
		Session session = sf.openSession();
		session.beginTransaction();
		Category c = (Category) session.load(Category.class, 1);
		System.out.println(c.getName());

		// 不跨Session
		Category c2 = (Category) session.load(Category.class, 1);
		System.out.println(c2.getName()); // 不执行SQL，从Session缓存取
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testSecondLevelCache() {
		Session session = sf.openSession();
		session.beginTransaction();
		Category c = (Category) session.load(Category.class, 1);
		System.out.println(c.getName());
		session.getTransaction().commit();
		session.close();

		// 跨Session
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Category c2 = (Category) session2.load(Category.class, 1);
		System.out.println(c2.getName()); // 不执行SQL，从二级缓存取
		session2.getTransaction().commit();
		session2.close();
	}

	@Test
	public void testQueryCache() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		q.setCacheable(true);
		System.out.println(q.list());
		session.getTransaction().commit();

		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2 = session2.createQuery("from Category");
		q2.setCacheable(true);
		// 注意：由于使用了缓存（实质是map），对应持久化类应当实现Serializable接口并重写equals和hashCode方法
		System.out.println(q2.list()); // 不执行SQL，从查询缓存取
		session2.getTransaction().commit();
	}

	@Test
	public void testQueryCache_iterate() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		q.setCacheable(true);
		System.out.println("\n" + q.list() + "\n");

		Query q2 = session.createQuery("from Category");
		q2.setCacheable(true);
		Iterator<Category> iterator = q2.iterate();
		StringBuilder s = new StringBuilder("\n" + "c.id\t" + "c.name\n");
		while (iterator.hasNext()) {
			Category c = iterator.next();
			s.append(c.getId() + "\t" + c.getName() + "\n");
		}
		System.out.println(s);
		session.getTransaction().commit();
	}
}
