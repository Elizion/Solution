package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.MaterialModel;
import com.ear.core.model.UnitModel;
import com.ear.core.payload.StorePriceRequest;

@Mapper
public interface MaterialMapper {
	
	public List<MaterialModel> getMaterials();

	public void createStorePrice(@Param("storePriceRequest") StorePriceRequest storePriceRequest);

	public List<UnitModel> getUnits();

	public Integer getIdMaterial(@Param("nameMaterial") String nameMaterial);

}
