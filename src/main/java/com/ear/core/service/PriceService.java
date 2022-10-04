package com.ear.core.service;

import java.text.ParseException;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

public interface PriceService {

	void insertPrice(PriceMaterialModel priceMaterial) throws ParseException;

	void modifiedPrice(StorePriceRequest storePriceRequest);

}
