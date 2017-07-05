package com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Org;
import com.service.OrgService;

public class OrgServiceTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("org-beans.xml");

	@Test
	public void testResource() {
		OrgService service = (OrgService) ctx.getBean("orgService");
		Org org = new Org();
		service.getOrgDao().save(org);
	}

	@Test
	@SuppressWarnings("unused")
	public void testLifeCycle() {
		ClassPathXmlApplicationContext ctx2 = new ClassPathXmlApplicationContext(
				"org-beans.xml");

		OrgService service = (OrgService) ctx2.getBean("orgService");

		ctx2.close();
	}
}
