package com.ear.core.service;

import java.util.List;

import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

public interface StoreService {

	public List<StoreModel> getListStore();

	public List<PriceMaterialModel> getStoreMaterialPrices(Integer idStore);

	public void createStorePrice(StorePriceRequest storePriceRequest);

	public Integer getIdStore(String nameStore, Integer code);

	public Integer getIdStoreType(String nameStoreType);

	public StoreModel getStoreByCode(Integer code);

	public void updateDeterminant(Integer code, String name, Integer determinant);

	public List<StoreTypeModel> getStoreTypes();

	public Integer getIdStoreByCode(Integer codeStore);

}
