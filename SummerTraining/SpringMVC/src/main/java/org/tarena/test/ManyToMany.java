package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tarena.entity.Student;
import org.tarena.entity.Teacher;
import org.tarena.util.SessionUtil;

public class ManyToMany {
	public static void main(String[] args) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Student s1 = new Student();
		s1.setSname("张三");
		Teacher t1 = new Teacher();
		t1.setTname("张老师");
		Teacher t2 = new Teacher();
		t2.setTname("郑老师");
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		session.saveOrUpdate(s1);
		tx.commit();
		session.close();
	}
}
