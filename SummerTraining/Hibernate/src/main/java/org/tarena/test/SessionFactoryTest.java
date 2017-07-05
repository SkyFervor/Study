package org.tarena.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.tarena.entity.Emp;

public class SessionFactoryTest {

	public static void main(String[] args) {
		// Configuration cfg = new Configuration();
		// SessionFactory factory = cfg.configure().buildSessionFactory();
		// Session session = factory.openSession();

		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(sr);

		Session session = factory.openSession();

		Emp emp;
		emp = (Emp) session.get(Emp.class, 2);
		System.out.println(emp);
	}
}
