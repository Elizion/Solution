package com.ear.core.repository;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

public interface PriceRepository {

	void insertPrice(PriceMaterialModel priceMaterial);

	void modifiedPrice(StorePriceRequest storePriceRequest);
	
}
