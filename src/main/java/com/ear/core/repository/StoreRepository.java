package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

public interface StoreRepository {

	public List<StoreModel> getListStore();

	public List<PriceMaterialModel> getStoreMaterialPrices(Integer idStore);

	public void createStorePrice(StorePriceRequest storePriceRequest);

	public Integer getIdStore(String nameStore, Integer code);

	public Integer getIdStoreType(String nameStoreType);

	public void updateNameStore(Integer id, String nameUpdate);

	public StoreModel getStoreByCode(Integer code);

	public void updateDeterminant(Integer code, String name, Integer determinant);

	public List<StoreTypeModel> getStoreTypes();

	public Integer getIdStoreByCode(Integer codeStore);

}
