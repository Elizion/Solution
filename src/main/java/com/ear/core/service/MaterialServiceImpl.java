package com.ear.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.MaterialModel;
import com.ear.core.model.UnitModel;
import com.ear.core.payload.StorePriceRequest;
import com.ear.core.repository.GenericRepository;
import com.ear.core.repository.MaterialRepository;

@Service
public class MaterialServiceImpl extends GenericRepository implements MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;

	@Override
	public List<MaterialModel> getMaterials() {		
		return this.materialRepository.getMaterials();		
	}

	@Override
	public void createStorePrice(StorePriceRequest storePriceRequest) {
		this.materialRepository.createStorePrice(storePriceRequest);
	}

	@Override
	public List<UnitModel> getUnits() {
		return this.materialRepository.getUnits();
	}

	@Override
	public Integer getIdMaterial(String nameMaterial) {
		return this.materialRepository.getIdMaterial(nameMaterial);
	}
		
}
