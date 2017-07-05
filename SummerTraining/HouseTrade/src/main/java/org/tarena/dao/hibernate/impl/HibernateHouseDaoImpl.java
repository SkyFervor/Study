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
import org.tarena.dao.HouseDao;
import org.tarena.entity.House;
import org.tarena.entity.HouseImage;

@Repository("houseDao")
public class HibernateHouseDaoImpl implements HouseDao {
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	// 获取所有House
	@Override
	public List<House> findAllHouse() {
		return hibernateTemplate.execute(new HibernateCallback<List<House>>() {

			@Override
			public List<House> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from House house order by house.id desc");
				return query.list();
			}

		});
	}

	// 根据where条件获取House
	@Override
	public List<House> findHouseByCondition(final String where) {
		return hibernateTemplate.execute(new HibernateCallback<List<House>>() {

			@Override
			public List<House> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from House house where " + where+" order by house.id desc";
				Query query = session.createQuery(hql);
				return query.list();
			}

		});
	}

	// 根据id获取House
	@Override
	public House findHouseById(final int id) {
		return hibernateTemplate.execute(new HibernateCallback<House>() {

			@Override
			public House doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from House house where house.id=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				List list = query.list();

				if (list.size() > 0)
					return (House) list.get(0);
				return null;
			}

		});
	}

	// 写入House对象
	@Override
	public void saveHouse(final House house) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.save(house);
				return null;
			}

		});
	}

	// 写入HouseImage对象
	@Override
	public void saveHouseImage(final HouseImage houseImage) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.save(houseImage);
				return null;
			}

		});
	}
}
