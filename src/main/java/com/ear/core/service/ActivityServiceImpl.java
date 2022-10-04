package com.ear.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;
import com.ear.core.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void createActivity(ActivityRequest activityRequest) {
		this.activityRepository.createActivity(activityRequest);	
	}

	@Override
	public List<ActivityModel> getAllActivities() {
		return this.activityRepository.getAllActivities();
	}
	
}
