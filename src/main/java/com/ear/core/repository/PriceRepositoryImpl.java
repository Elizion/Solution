package com.ear.core.repository;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.PriceMapper;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

@Repository
public class PriceRepositoryImpl extends GenericRepository implements PriceRepository {
	
	@Override
	public void insertPrice(PriceMaterialModel priceMaterial) {		
		PriceMapper mapper = super.getSqlSession().getMapper( PriceMapper.class );
		mapper.insertPrice(priceMaterial);		
	}

	@Override
	public void modifiedPrice(StorePriceRequest storePriceRequest) {
		PriceMapper mapper = super.getSqlSession().getMapper( PriceMapper.class );
		mapper.modifiedPrice(storePriceRequest);		
	}	
	
}

