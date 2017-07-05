package pojo;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class QBCTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		try {
			sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
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
			session.save(c);
		}

		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setName("t" + i);
			t.setCreateDate(new Date());
			t.setCategory(c);
			session.save(t);
		}

		for (int i = 0; i < 10; i++) {
			Topic t = new Topic();
			t.setId(1);
			Message m = new Message();
			m.setName("m" + i);
			m.setTopic(t);
			session.save(m);
		}

		session.getTransaction().commit();
	}

	@Test
	public void testQBC() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		Criteria c = session.createCriteria(Topic.class).add(Restrictions.gt("id", 2));
		c.add(Restrictions.lt("id", 8));
		c.add(Restrictions.like("name", "t_"));
		c.createCriteria("category").add(Restrictions.between("id", 1, 5));
		// DetachedCriteria

		for (Object o : c.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getId() + " - " + t.getName());
		}

		session.getTransaction().commit();
	}
}
