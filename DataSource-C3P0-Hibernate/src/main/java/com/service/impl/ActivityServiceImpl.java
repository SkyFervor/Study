package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ActivityDao;
import com.model.Activity;
import com.service.ActivityService;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDao activityDao;

	public void add(Activity activity) {
		activityDao.save(activity);
	}
}
