package org.tarena.dao.hibernate.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;
import org.tarena.util.SessionUtil;

public class HibernateEmpDaoImpl implements EmpDao {

	@Override
	public void saveEmp(Emp emp) throws SQLException {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.save(emp);

		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listEmp() throws SQLException {
		Session session = SessionUtil.getSession();

		String hql = "from Emp";
		Query query = session.createQuery(hql);

		return query.list();
	}

	@Override
	public void deleteEmpById(int id) throws SQLException {
		Session session = SessionUtil.getSession();
		session.beginTransaction();

		String hql = "delete from Emp e where e.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Emp findEmpById(int id) throws SQLException {
		Session session = SessionUtil.getSession();

		Emp emp = (Emp) session.get(Emp.class, id);

		session.close();
		return emp;
	}

	@Override
	public void updateEmp(Emp emp) throws SQLException {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(emp);

		tx.commit();
		session.close();
	}

	@Override
	public Emp findEmpByAccount(String account) throws SQLException {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Emp e where e.account=?";
		Query query = session.createQuery(hql);
		query.setString(0, account);
		Emp emp = (Emp) query.uniqueResult();

		tx.commit();
		return emp;
	}
}
