package com.dao.impl;

import org.springframework.stereotype.Component;

import com.dao.OrgDao;
import com.model.Org;

//声明为bean
@Component("orgDao")
// @Controller("orgDao")
// @Service("orgDao")
// @Repository("orgDao")
public class OrgDaoImpl implements OrgDao {

	public void save(Org org) {
		System.out.println("a org saved");
	}

}
