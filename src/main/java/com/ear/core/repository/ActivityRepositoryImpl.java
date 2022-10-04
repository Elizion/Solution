package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.ActivityMapper;
import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;

@Repository
public class ActivityRepositoryImpl extends GenericRepository implements ActivityRepository {

	@Override
	public void createActivity(ActivityRequest activityRequest) {
		ActivityMapper mapper = super.getSqlSession().getMapper( ActivityMapper.class );
		mapper.createActivity(activityRequest);
	}

	@Override
	public List<ActivityModel> getAllActivities() {
		ActivityMapper mapper = super.getSqlSession().getMapper( ActivityMapper.class );
		return mapper.getAllActivities();
	}

}
