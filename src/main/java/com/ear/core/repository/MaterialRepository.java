package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.MaterialModel;
import com.ear.core.model.UnitModel;
import com.ear.core.payload.StorePriceRequest;

public interface MaterialRepository {

	public List<MaterialModel> getMaterials();

	public void createStorePrice(StorePriceRequest storePriceRequest);

	public List<UnitModel> getUnits();

	public Integer getIdMaterial(String nameMaterial);
	
}
