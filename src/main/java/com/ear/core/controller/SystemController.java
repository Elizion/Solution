package com.ear.core.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.DateModel;
import com.ear.core.service.SystemService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/system")
public class SystemController {

	@Autowired
	private SystemService systemService;
	
	public final static Logger logger = Logger.getLogger(SystemController.class);
	
	@GetMapping("get/date")
	public ResponseEntity<Object> getDateSystem(@RequestParam String timezone) {				
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
			TimeZone tz = TimeZone.getTimeZone(timezone);			
			sdf.setTimeZone(tz);			
			Date date = this.systemService.getDateSystem();			
			Calendar calendar = Calendar.getInstance(tz);
			calendar.setTime(date);			
			String dateAsString = sdf.format(date);			
			DateModel dateModel = new DateModel();
			dateModel.setDate(calendar.getTime());
			dateModel.setDateAsString(dateAsString);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, dateModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}

}
