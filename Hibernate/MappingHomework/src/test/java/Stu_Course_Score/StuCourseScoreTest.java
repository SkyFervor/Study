package Stu_Course_Score;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class StuCourseScoreTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		sf = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

	@Test
	public void testSaveFromScore() {
		Student s = new Student();
		s.setName("zhangsan");
		Course c = new Course();
		c.setName("java");
		Score score = new Score();
		score.setStudent(s);
		score.setCourse(c);

		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(score);
		session.getTransaction().commit();
	}

	@Test
	public void testSaveFromStu() {
		Course c = new Course();
		c.setName("C++");
		Student s = new Student();
		s.setName("lisi");
		s.getCourses().add(c);

		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();

	}

	@Test
	public void testLoad() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		Student s = (Student) session.load(Student.class, 1);
		for (Course c : s.getCourses())
			System.out.println(c.getName());

		session.getTransaction().commit();
	}
}
