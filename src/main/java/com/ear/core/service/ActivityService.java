package com.ear.core.service;

import java.util.List;

import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;

public interface ActivityService {

	void createActivity(ActivityRequest activityRequest);

	List<ActivityModel> getAllActivities();

}
