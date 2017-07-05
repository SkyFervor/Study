package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
	}
}
