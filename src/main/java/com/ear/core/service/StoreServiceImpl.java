package com.ear.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;
import com.ear.core.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public List<StoreModel> getListStore() {
		return this.storeRepository.getListStore();
	}

	@Override
	public List<PriceMaterialModel> getStoreMaterialPrices(Integer idStore) {
		return this.storeRepository.getStoreMaterialPrices(idStore);
	}

	@Override
	public void createStorePrice(StorePriceRequest storePriceRequest) {		
		this.storeRepository.createStorePrice(storePriceRequest);		
	}

	@Override
	public Integer getIdStore(String nameStore, Integer code) {
		return this.storeRepository.getIdStore(nameStore, code);
	}

	@Override
	public Integer getIdStoreType(String nameStoreType) {
		return this.storeRepository.getIdStoreType(nameStoreType);
	}

	@Override
	public StoreModel getStoreByCode(Integer code) {
		return this.storeRepository.getStoreByCode(code);
	}

	@Override
	public void updateDeterminant(Integer code, String name, Integer determinant) {
		this.storeRepository.updateDeterminant(code, name, determinant);
	}

	@Override
	public List<StoreTypeModel> getStoreTypes() {
		return this.storeRepository.getStoreTypes();
	}

	@Override
	public Integer getIdStoreByCode(Integer codeStore) {
		return this.storeRepository.getIdStoreByCode(codeStore);
	}

}
