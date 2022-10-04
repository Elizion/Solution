package com.ear.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.ActivityModel;
import com.ear.core.payload.ActivityRequest;
import com.ear.core.service.ActivityService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/activity")
public class ActivityController {

	public final static Logger logger = Logger.getLogger(ActivityController.class);

	@Autowired
	private ActivityService activityService;
	
	@PostMapping("created")
	public ResponseEntity<Object> createActivity(@RequestBody ActivityRequest activityRequest) {				
		
		try {
							
			this.activityService.createActivity(activityRequest);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, "Actividad registrada correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/all")
	public ResponseEntity<Object> getAllActivities() {				
		
		try {
							
			List<ActivityModel> listActivityModel = this.activityService.getAllActivities();
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listActivityModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	
	
}
