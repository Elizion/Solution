package com.ear.core.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;
import com.ear.core.repository.GenericRepository;
import com.ear.core.repository.PriceRepository;

@Service
public class PriceServiceImpl extends GenericRepository implements PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public void insertPrice(PriceMaterialModel priceMaterial) throws ParseException {
		this.priceRepository.insertPrice(priceMaterial);		
	}

	@Override
	public void modifiedPrice(StorePriceRequest storePriceRequest) {
		this.priceRepository.modifiedPrice(storePriceRequest);
	}

}
