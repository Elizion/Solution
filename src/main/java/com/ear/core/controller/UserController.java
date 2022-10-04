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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;
import com.ear.core.service.UserService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/user")
public class UserController {

	public final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("created")
	public ResponseEntity<Object> createUser(@RequestBody UserRequest userRequest) {				
		
		try {
						
			userRequest = this.userService.createUser(userRequest);		
			UserModel userModel = this.userService.getUserByEmail(userRequest.getEmail());			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, userModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get")
	public ResponseEntity<Object> getUserByEmail(@RequestParam String email) {				
		
		try {
					
			UserModel userModel = this.userService.getUserByEmail(email);			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, userModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("desactivated")
	public ResponseEntity<Object> desactivatedUserByEmail(@RequestParam String email) {				
		
		try {
					
			UserModel userModel = this.userService.getUserByEmail(email);				
			this.userService.desactivatedUserByEmail(userModel.getId());			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "El usuario " + userModel.getName() + " " + userModel.getLastName() + " esta dado de baja.");
			 
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("activated")
	public ResponseEntity<Object> activatedUserByEmail(@RequestParam String email) {				
		
		try {
					
			UserModel userModel = this.userService.getUserByEmail(email);				
			this.userService.activatedUserByEmail(userModel.getId());			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "El usuario " + userModel.getName() + " " + userModel.getLastName() + " esta activado.");
			 
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/actives")
	public ResponseEntity<Object> getUserActives() {				
		
		try {
					
			List<UserModel> listUserModel = this.userService.getUserActives();			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listUserModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	  
}