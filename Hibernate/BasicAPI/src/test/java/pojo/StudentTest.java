package pojo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;
import java.util.EnumSet;

public class StudentTest {
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
		Student student = new Student();
		student.setName("s0");
		student.setBirthDay(new Date());

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(student);
		tx.commit();
		System.out.println(student.getId());
	}

	@Test
	public void testLoad() {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Student s = (Student) session.load(Student.class, 1);
		System.out.println(s.getName()); // 取值时才执行SQL
		tx.commit();
		System.out.println(s.getClass()); // 代理对象 != pojo.Student

		// load 不存在的记录
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();

		Student s2 = (Student) session2.load(Student.class, 100);
		session2.getTransaction().commit();
		System.out.println(s2 == null);
	}

	@Test
	public void testGet() {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Student s = (Student) session.get(Student.class, 1);
		System.out.println(s.getName()); // get方法中执行SQL
		tx.commit();

		System.out.println(s.getClass()); // == pojo.Student

		// get 不存在的记录
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();

		Student s2 = (Student) session2.get(Student.class, 100);
		session2.getTransaction().commit();
		System.out.println(s2 == null);
	}

	@Test
	public void testUpdate1() {
		// update Persistent状态的对象
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Student s = (Student) session.get(Student.class, 1);
		s.setName("s1");

		session.update(s); // 此句加与不加效果相同
		tx.commit();
	}

	@Test
	public void testUpdate2() {
		// update 设置了ID的Transient状态的对象
		Student s = new Student();
		s.setId(1);
		s.setName("s2");

		Session session = sf.getCurrentSession();
		session.beginTransaction();

		session.update(s); // 不论dynamicUpdate如何设置，均更新全部字段
		// 注意可能造成已有数据的丢失
		// 若主键对应记录不存在报错
		session.getTransaction().commit();
	}

	@Test
	public void testUpdate3() {
		// update Detached状态的对象
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		Student s = (Student) session.get(Student.class, 1);
		session.getTransaction().commit();

		s.setName("s3");

		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();

		session2.update(s); // 不论dynamicUpdate如何设置，均更新全部字段
		// 实质和testUpdate2相同
		session2.getTransaction().commit();
	}

	@Test
	public void testUpdate4() {
		// HQL 更加灵活的更新
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("update Student s set s.name = ? where id = ?");
		q.setString(0, "s4");
		q.setInteger(1, 1);
		q.executeUpdate();
		session.getTransaction().commit();
	}

	@Test
	public void testDelete() {
		Student s = new Student();
		s.setId(1);
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(s);
		tx.commit();

		System.out.println(s.getId());

		// delete 不存在的记录
		Student s2 = new Student();
		s2.setId(100);
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.delete(s2);
		session2.getTransaction().commit(); // 报错

		System.out.println(s2.getId());
	}

	@Test
	public void testSchemaExport() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
}
