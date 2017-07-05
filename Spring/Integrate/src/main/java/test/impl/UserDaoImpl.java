package test.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import test.dao.UserDao;
import test.model.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sf;

	@Override
	public void save(User user) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}
