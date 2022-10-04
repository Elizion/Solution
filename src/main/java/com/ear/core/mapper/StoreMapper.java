package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

public interface StoreMapper {

	public List<StoreModel> getListStore();

	public List<PriceMaterialModel> getStoreMaterialPrices(@Param("idStore") Integer idStore);

	public void createStorePrice(@Param("storePriceRequest") StorePriceRequest storePriceRequest);

	public Integer getIdStore(@Param("nameStore") String nameStore, @Param("code") Integer code);

	public Integer getIdStoreType(@Param("nameStoreType") String nameStoreType);

	public void updateNameStore(@Param("id") Integer id, @Param("nameUpdate") String nameUpdate);

	public StoreModel getStoreByCode(@Param("code") Integer code);

	public void updateDeterminant(@Param("code") Integer code, @Param("name") String name, @Param("determinant") Integer determinant);

	public List<StoreTypeModel> getStoreTypes();

	public Integer getIdStoreByCode(@Param("codeStore") Integer codeStore);

}
