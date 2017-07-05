package org.tarena.dao.hibernate.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.dao.UserDao;
import org.tarena.entity.User;

@Repository("userDao")
public class HibernateUserDaoImpl implements UserDao {
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	// 根据账号获取User
	@Override
	public User findUserByAccount(final String account) {
		return hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from User user where user.account=?";
				Query query = session.createQuery(hql);
				query.setString(0, account);
				List list = query.list();

				if (list.size() > 0)
					return (User) list.get(0);
				return null;
			}

		});
	}

	// 写入User对象
	@Override
	public void saveUser(final User user) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.save(user);
				return null;
			}

		});
	}
}
