package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;

public interface ActivityRepository {

	public void createActivity(ActivityRequest activityRequest);

	public List<ActivityModel> getAllActivities();

}
