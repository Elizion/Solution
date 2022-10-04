package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.StoreMapper;
import com.ear.core.model.StoreModel;
import com.ear.core.model.StoreTypeModel;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.payload.StorePriceRequest;

@Repository
public class StoreRepositoryImpl extends GenericRepository implements StoreRepository {

	@Override
	public List<StoreModel> getListStore() {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getListStore();
	}

	@Override
	public List<PriceMaterialModel> getStoreMaterialPrices(Integer idStore) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getStoreMaterialPrices(idStore);
	}

	@Override
	public void createStorePrice(StorePriceRequest storePriceRequest) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		mapper.createStorePrice(storePriceRequest);
	}

	@Override
	public Integer getIdStore(String nameStore, Integer code) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getIdStore(nameStore, code);
	}

	@Override
	public Integer getIdStoreType(String nameStoreType) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getIdStoreType(nameStoreType);
	}

	@Override
	public void updateNameStore(Integer id, String nameUpdate) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		mapper.updateNameStore(id, nameUpdate);
	}

	@Override
	public StoreModel getStoreByCode(Integer code) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getStoreByCode(code);
	}

	@Override
	public void updateDeterminant(Integer code, String name, Integer determinant) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		mapper.updateDeterminant(code, name, determinant);		
	}

	@Override
	public List<StoreTypeModel> getStoreTypes() {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getStoreTypes();
	}

	@Override
	public Integer getIdStoreByCode(Integer codeStore) {
		StoreMapper mapper = super.getSqlSession().getMapper( StoreMapper.class );
		return mapper.getIdStoreByCode(codeStore);
	}

}
