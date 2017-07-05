package org.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
	private static SessionFactory FACTORY;

	static {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		FACTORY = cfg.buildSessionFactory(sr);
	}

	public static Session getSession() {
		return FACTORY.openSession();
	}
}
