package com.dao.impl;

import com.dao.ActivityDao;
import com.dao.SuperDao;
import com.model.Activity;
import org.springframework.stereotype.Repository;

@Repository("activityDao")
public class ActivityDaoImpl extends SuperDao implements ActivityDao {

	@Override
	public void save(Activity activity) {
		getSession().save(activity);
	}

}
