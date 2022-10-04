package com.ear.core.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.service.StoreService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	public final static Logger logger = Logger.getLogger(StoreController.class);
	
	@GetMapping("get/actives")
	public ResponseEntity<Object> getListStore() {				
		
		try {			
			
			List<StoreModel> listStoreModel =  this.storeService.getListStore();			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listStoreModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/prices")
	public ResponseEntity<Object> getStoreMaterialPrices(@RequestParam Integer idStore) {				
		
		try {			
			
			List<PriceMaterialModel> listPriceMaterialModel =  this.storeService.getStoreMaterialPrices(idStore);			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listPriceMaterialModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/types")
	public ResponseEntity<Object> getStoreTypes() {				
		
		try {			
			
			List<StoreTypeModel> listStoreTypeModel =  this.storeService.getStoreTypes();			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listStoreTypeModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
}
