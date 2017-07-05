package pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;

import java.util.EnumSet;
import java.util.List;

public class ORMTest {
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
	public void testSchemaExport() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void testAssociativeSave() {
		Group group = new Group();
		group.setName("group1");
		User user1 = new User();
		user1.setName("user1");
		user1.setGroup(group);
		User user2 = new User();
		user2.setName("user2");
		user2.setGroup(group);
		group.getUsers().add(user1);
		group.getUsers().add(user2);

		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(group);
		session.getTransaction().commit();
	}

	@Test
	public void testAssociativeGet() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Group g = (Group) session.get(Group.class, 1);
		List<User> users = g.getUsers();
		for (User user : users) {
			System.out.print("Group:\t" + user.getGroup().getName());
			System.out.println("\tUser:" + user.getName());
		}

		session.getTransaction().commit();
	}

	@Test
	public void testGetWife() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Husband husband = (Husband) session.get(Husband.class, 1);
		System.out.println(husband.getWife().getName());
		session.getTransaction().commit();
	}
}
