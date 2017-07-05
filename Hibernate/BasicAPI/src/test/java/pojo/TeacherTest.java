package pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class TeacherTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		try {
			sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

	public static void main(String[] args) {
		beforeClass();
	}

	@Test
	public void testSave() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("t1");
		t.setGender(Gender.MALE);
		t.setHobby("123");

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();

		System.out.println(t.getId());
	}

}
