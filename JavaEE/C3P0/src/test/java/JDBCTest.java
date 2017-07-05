import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDao;
import dao.jdbc.UserDaoImpl;
import entity.User;

public class JDBCTest {
	private static UserDao userDao = null;

	@BeforeClass
	public static void beforeClass() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setAccount("123");
		user.setPassword("123");

		System.out.println(userDao.save(user));
	}

	@Test
	public void testGet() {
		int id = 1;

		User user = userDao.get(id);
		System.out.println(user.getId() + "\t" + user.getAccount() + "\t" + user.getPassword()
				+ "\t" + user.getName() + "\t" + user.getAge() + "\t" + user.getSex());
	}

	@Test
	public void testUpdate() {
		int id = 1;
		User user = userDao.get(id);

		user.setAge(user.getAge() + 1);
		System.out.println(userDao.update(user));
	}
}
