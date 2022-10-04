package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.MaterialMapper;
import com.ear.core.model.MaterialModel;
import com.ear.core.model.UnitModel;
import com.ear.core.payload.StorePriceRequest;

@Repository
public class MaterialRepositoryImpl extends GenericRepository implements MaterialRepository {

	@Override
	public List<MaterialModel> getMaterials() {
		MaterialMapper mapper = super.getSqlSession().getMapper( MaterialMapper.class );
		return mapper.getMaterials();
	}

	@Override
	public void createStorePrice(StorePriceRequest storePriceRequest) {
		MaterialMapper mapper = super.getSqlSession().getMapper( MaterialMapper.class );
		mapper.createStorePrice(storePriceRequest);		
	}

	@Override
	public List<UnitModel> getUnits() {		
		MaterialMapper mapper = super.getSqlSession().getMapper( MaterialMapper.class );
		return mapper.getUnits();	
	}

	@Override
	public Integer getIdMaterial(String nameMaterial) {
		MaterialMapper mapper = super.getSqlSession().getMapper( MaterialMapper.class );
		return mapper.getIdMaterial(nameMaterial);
	}
	
}

