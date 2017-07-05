package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.OrgDao;
import com.model.Org;

// 声明为bean，可以使用getBean获取
// 不指定bean-name则默认为类名首字母小写
@Component("orgService")
public class OrgService {
	private OrgDao orgDao;

	// =init-method
	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	// =destroy-method
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

	// 根据name注入
	@Resource(name = "orgDao")
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	public void add(Org org) {
		orgDao.save(org);
	}
}
