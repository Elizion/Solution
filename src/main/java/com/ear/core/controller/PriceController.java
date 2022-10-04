package com.ear.core.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ear.core.config.SolutionConst;
import com.ear.core.payload.StorePriceRequest;
import com.ear.core.service.MaterialService;
import com.ear.core.service.PriceService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/price")
public class PriceController {

	@Autowired
	private MaterialService materialService;

	@Autowired
	private PriceService priceService;

	public final static Logger logger = Logger.getLogger(PriceController.class);
	
	@PutMapping("modified")
	public ResponseEntity<Object> modifiedStorePrice(@RequestBody StorePriceRequest storePriceRequest) {
		
		System.out.println(storePriceRequest.getIdPrice() + " " + storePriceRequest.getPrice());
		this.priceService.modifiedPrice(storePriceRequest);
		return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "Precio editado correctamente");
		
	}
	
	
	@PostMapping("created")
	public ResponseEntity<Object> createStorePrice(@RequestBody StorePriceRequest storePriceRequest) {				
		
		try {			
			
			this.materialService.createStorePrice(storePriceRequest);		
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "Peecio creado correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
}
