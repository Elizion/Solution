package com.ear.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.MaterialModel;
import com.ear.core.model.UnitModel;
import com.ear.core.service.MaterialService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	public final static Logger logger = Logger.getLogger(MaterialController.class);
	
	@GetMapping("get/units/actives")
	public ResponseEntity<Object> getUnits() {				
		
		try {
				
			List<UnitModel> listUnitModel = this.materialService.getUnits();		
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listUnitModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/actives")
	public ResponseEntity<Object> getMaterials() {				
		
		try {
				
			List<MaterialModel> listMaterialModel = this.materialService.getMaterials();		
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listMaterialModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
}
