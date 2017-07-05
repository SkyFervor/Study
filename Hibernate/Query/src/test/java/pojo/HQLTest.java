package pojo;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class HQLTest {
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

		Category c = new Category();
		c.setId(1);
		for (int i = 0; i < 10; i++) {
			Topic t = new Topic();
			t.setName("t" + i);
			t.setCreateDate(new Date());
			t.setCategory(c);
			session.save(t);
		}

		Topic t = new Topic();
		t.setId(1);
		for (int i = 0; i < 10; i++) {
			Message m = new Message();
			m.setName("m" + i);
			m.setTopic(t);
			session.save(m);
		}

		session.getTransaction().commit();
	}

	@Test
	public void testHQL_01() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_02() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c where c.name > 'c9'");
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_03() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c order by c.name desc");
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_04() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select distinct c from Category c order by c.name desc");
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_05() {
		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Query q = session.createQuery(
		 * "from Category c where c.id > :min and c.id < :max");
		 * //q.setParameter("min", 2); //q.setParameter("max", 8);
		 * q.setInteger("min", 2); q.setInteger("max", 8);
		 */

		Query q = session.createQuery("from Category c where c.id > :min and c.id < :max").setInteger("min", 2)
				.setInteger("max", 8);
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getId() + " - " + c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_06() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c where c.id > ? and c.id < ?");
		q.setParameter(0, 2).setParameter(1, 8);
		// q.setParameter(1, 8);
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getId() + " - " + c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// 分页
	@Test
	public void testHQL_07() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c order by c.name desc");
		q.setMaxResults(4);
		q.setFirstResult(3);
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getId() + " - " + c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_08() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select c.id,  c.name from Category c order by c.name desc");
		List<Object[]> categories = (List<Object[]>) q.list();
		for (Object[] o : categories) {
			System.out.println(o[0] + " - " + o[1]);
		}
		session.getTransaction().commit();
		session.close();

	}

	// 设定fetch type 为lazy后将不会有第二条sql语句
	@Test
	public void testHQL_09() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.category.id = 1");
		List<Topic> topics = (List<Topic>) q.list();
		for (Topic t : topics)
			System.out.println(t.getName());

		session.getTransaction().commit();
		session.close();

	}

	// 设定fetch type 为lazy后将不会有第二条sql语句
	@Test
	public void testHQL_10() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message m where m.topic.category.id = 1");
		List<Message> messages = (List<Message>) q.list();

		for (Message m : messages)
			System.out.println(m.getName());

		session.getTransaction().commit();
		session.close();

	}

	// select new DTO(...)
	// VO = Value Object
	// DTO = data transfer object
	// 类似临时视图
	@Test
	public void testHQL_11() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery(
				"select new pojo.MsgInfo(m.id, m.name, m.topic.name, m.topic.category.name) from Message m");

		for (Object o : q.list()) {
			MsgInfo m = (MsgInfo) o;
			System.out.println(m.getMsgName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// join
	// 动手测试left right join
	// 为什么不能直接写Category名，而必须写t.category
	// 因为有可能存在多个成员变量（同一个类），需要指明用哪一个成员变量的连接条件来做连接
	@Test
	public void testHQL_12() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.name, c.name from Topic t join t.category c "); // join
																								// c
		for (Object o : q.list()) {
			Object[] m = (Object[]) o;
			System.out.println(m[0] + " - " + m[1]);
		}
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testHQL_12_1() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t inner join t.category c");
		List<Object[]> list = (List<Object[]>) q.list();

		System.out.println("\n" + "t.id\t" + "t.name\t" + "t.createDate\t" + "c.id\t" + "c.name");
		for (Object[] os : list) {
			Topic t = (Topic) os[0];
			Category c = (Category) os[1];
			System.out.println(t + "\t" + c);
		}
	}

	// uniqueResult
	@Test
	public void testHQL_13() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message m where m = :MsgToSearch "); // 不重要
		Message m = new Message();
		m.setId(1);
		q.setParameter("MsgToSearch", m);

		Message mResult = (Message) q.uniqueResult();
		System.out.println(mResult.getName());
		session.getTransaction().commit();
		session.close();

	}

	// 聚集函数1
	@Test
	public void testHQL_14() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select count(*) from Message m");

		long count = (Long) q.uniqueResult();
		System.out.println(count);
		session.getTransaction().commit();
		session.close();

	}

	// 聚集函数2
	@Test
	public void testHQL_15() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select max(m.id), min(m.id), avg(m.id), sum(m.id) from Message m");

		Object[] o = (Object[]) q.uniqueResult();
		System.out.println(o[0] + " - " + o[1] + " - " + o[2] + " - " + o[3]);
		session.getTransaction().commit();
		session.close();

	}

	// between ... and ...
	@Test
	public void testHQL_16() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message m where m.id between 3 and 5");

		for (Object o : q.list()) {
			Message m = (Message) o;
			System.out.println(m.getId() + " - " + m.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// IN(...)
	@Test
	public void testHQL_17() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message m where m.id IN(3, 4, 5)");

		for (Object o : q.list()) {
			Message m = (Message) o;
			System.out.println(m.getId() + " - " + m.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// is null / is not null
	@Test
	public void testHQL_18() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message m where m.name is not null");

		for (Object o : q.list()) {
			Message m = (Message) o;
			System.out.println(m.getId() + " - " + m.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// is empty / is not empty
	@Test
	public void testHQL_20() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.messages is empty");

		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// like %
	@Test
	public void testHQL_21() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.name like '%5'");

		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// like _
	@Test
	public void testHQL_22() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.name like '_5'");

		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getId() + " - " + t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// 标量函数
	@Test
	public void testHQL_23() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery(
				"select lower(t.name), upper(t.name), trim(t.name), concat(t.name, '***'), length(t.name) from Topic t ");

		for (Object o : q.list()) {
			Object[] arr = (Object[]) o;
			System.out.println(arr[0] + " - " + arr[1] + " - " + arr[2] + " - " + arr[3] + " - " + arr[4] + " - ");
		}
		session.getTransaction().commit();
		session.close();

	}

	// 数学函数
	@Test
	public void testHQL_24() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select abs(t.id)," + "sqrt(t.id)," + "mod(t.id, 2)" + " from Topic t ");

		for (Object o : q.list()) {
			Object[] arr = (Object[]) o;
			System.out.println(arr[0] + " - " + arr[1] + " - " + arr[2]);
		}
		session.getTransaction().commit();
		session.close();

	}

	// 内部变量
	@Test
	public void testHQL_25() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session
				.createQuery("select current_date, current_time, current_timestamp from Topic t where t.id = 1");

		for (Object o : q.list()) {
			Object[] arr = (Object[]) o;
			System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2]);
		}
		session.getTransaction().commit();
		session.close();

	}

	// 时间比较
	@Test
	public void testHQL_26() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.createDate < :date");
		q.setParameter("date", new Date());
		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// group by
	@Test
	public void testHQL_27() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.name, count(*) from Topic t group by t.name");
		for (Object o : q.list()) {
			Object[] arr = (Object[]) o;
			System.out.println(arr[0] + " | " + arr[1]);
		}
		session.getTransaction().commit();
		session.close();
	}

	// group by ... having ...
	@Test
	public void testHQL_28() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.name, count(*) from Topic t group by t.name having count(*) >= 1");
		for (Object o : q.list()) {
			Object[] arr = (Object[]) o;
			System.out.println(arr[0] + " | " + arr[1]);
		}
		session.getTransaction().commit();
		session.close();

	}

	// select嵌套
	@Test
	public void testHQL_29() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.id < (select avg(t.id) from Topic t)");
		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// < ALL(...)
	@Test
	public void testHQL_30() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session
				.createQuery("from Topic t where t.id < ALL (select t.id from Topic t where mod(t.id, 2)= 0) ");
		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// exists
	// 用in 可以实现exists的功能
	// 但是exists执行效率高
	@Test
	public void testHQL_31() {
		Session session = sf.openSession();
		session.beginTransaction();// t.id not in (1)
		Query q = session
				.createQuery("from Topic t where not exists (select m.id from Message m where m.topic.id=t.id)");
		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

	// update / delete
	// 规范并没有说明是不是要更新persistent object，所以如果要使用，建议在单独的trasaction中执行
	@Test
	public void testHQL_32() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("update Topic t set t.name = upper(t.name)");

		q.executeUpdate();
		q = session.createQuery("from Topic");
		for (Object o : q.list()) {
			Topic t = (Topic) o;
			System.out.println(t.getName());
		}
		session.createQuery("update Topic t set t.name = lower(t.name)").executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

	// NamedQuery
	@Test
	public void testHQL_33() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.getNamedQuery("topic.selectCertainTopic");
		q.setParameter("id", 5);
		Topic t = (Topic) q.uniqueResult();
		System.out.println(t.getName());
		session.getTransaction().commit();
		session.close();

	}

	// NativeSQL
	@Test
	public void testHQL_34() {
		Session session = sf.openSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery("select * from category limit 2,4").addEntity(Category.class);
		List<Category> categories = (List<Category>) q.list();
		for (Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();

	}

}
