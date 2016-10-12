package com.bp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bp.dao.QueueDao;
import com.bp.service.QueueService;

public class QueueServiceImpl implements QueueService {
	@Autowired
	private QueueDao queueDao;

	@Override
	public boolean addPerson(Long activityId, Long customer) {
		return queueDao.addPerson(activityId, customer);
	}


	@Override
	public String removePerson(Long activityId) {
		return queueDao.removePerson(activityId);
	}

	@Override
	public Long getPerson(Long activityId) {
		return queueDao.getPerson(activityId);
	}

}
