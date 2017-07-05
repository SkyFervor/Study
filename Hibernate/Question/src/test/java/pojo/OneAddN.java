package pojo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class OneAddN {
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
	public void testSave() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setName("c" + i);
			Topic t = new Topic();
			t.setName("t" + i);
			t.setCreateDate(new Date());
			t.setCategory(c);
			session.save(c);
			session.save(t);
		}
		session.getTransaction().commit();
	}

	// 1+N
	@Test
	public void testQuestion() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		// 将会先发出一条查询topic的SQL，再发出n条查询每个topic对应category的SQL
		List<Topic> topics = (List<Topic>) session.createQuery("from Topic").list();

		for (Topic t : topics) {
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
	}

	// 解决方式一
	// FetchType.LAZY
	// 给Topic.class中的@ManyToOne加上(fetch=FetchType.LAZY)

	// 解决方式二
	// @BatchSize
	// 给Category.class加上@BatchSize(size=n)，一次取出n个topic对应的category，减少总查询次数

	// 解决方式三
	// join fetch
	// 显式使用外连接语句，将关联对象一起获取
	@Test
	public void testHQL() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		List<Topic> topics = (List<Topic>) session.createQuery(
				"from Topic t left join fetch t.category c").list();

		for (Topic t : topics) {
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
	}

	// 解决方式四
	// createCriteria
	// 替换HQL为QBC (隐式转化为外连接SQL)
	@Test
	public void testQBC() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		List<Topic> topics = (List<Topic>) session.createCriteria(Topic.class).list();

		for (Topic t : topics) {
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
	}
}
