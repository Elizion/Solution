package com.ear.core.controller;

import org.apache.log4j.Logger;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.UserModel;
import com.ear.core.service.UserService;
import com.ear.core.util.ResponseHandler;
import com.ear.core.util.SolutionException;

@RestController
@RequestMapping("api/session")
public class SessionController {
	
	final static Logger logger = Logger.getLogger(SessionController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signin")
	public ResponseEntity<Object> getSessionUser(Principal user) throws SolutionException {						
		
		String email = user.getName();
		
		try {
						
			UserModel userModel = this.userService.getUserByEmail(email);
			logger.info("El usuario con correo " + email + " ha iniciado sesi\u00f3n");			
	        
			if(userModel == null) {
				throw new BadCredentialsException("No user registered with this details!");			
			}

			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, userModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

	}
	
}
