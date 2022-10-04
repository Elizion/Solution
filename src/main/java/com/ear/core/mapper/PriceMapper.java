package com.ear.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

@Mapper
public interface PriceMapper {

	void insertPrice(@Param("priceMaterial") PriceMaterialModel priceMaterial);

	void modifiedPrice(@Param("storePriceRequest") StorePriceRequest storePriceRequest);

	
}
