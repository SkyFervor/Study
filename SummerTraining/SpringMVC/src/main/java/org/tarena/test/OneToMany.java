package org.tarena.test;

import java.util.Set;

import org.hibernate.Session;
import org.tarena.entity.Dept;
import org.tarena.entity.Emp;
import org.tarena.util.SessionUtil;

public class OneToMany {
	public static void main(String[] args) {
		Session session = SessionUtil.getSession();
		Dept dept = (Dept) session.get(Dept.class, 2);
		Set<Emp> emps = dept.getEmps();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
}
