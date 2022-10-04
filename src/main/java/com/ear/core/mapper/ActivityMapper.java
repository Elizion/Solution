package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;

public interface ActivityMapper {

	public void createActivity(@Param("activityRequest") ActivityRequest activityRequest);

	public List<ActivityModel> getAllActivities();

}
