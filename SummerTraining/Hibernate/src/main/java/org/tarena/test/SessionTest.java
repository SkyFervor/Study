package org.tarena.test;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.tarena.entity.Emp;
import org.tarena.util.SessionUtil;

public class SessionTest {

	public void saveEmp() {
		Emp emp = new Emp();
		emp.setEname("刘");
		emp.setSalary(new BigDecimal(6000));
		emp.setAge(23);

		Session session = SessionUtil.getSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmp() {
		int id = 12;
		Session session = SessionUtil.getSession();
		session.beginTransaction();

		String hql = "delete from Emp e where e.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void updateEmp() {
		Session session = SessionUtil.getSession();
		session.beginTransaction();

		int id = 6;
		Emp emp = (Emp) session.get(Emp.class, id);
		emp.setSalary(new BigDecimal(4000));

		session.update(emp);
		session.getTransaction().commit();
		session.close();
	}
}
