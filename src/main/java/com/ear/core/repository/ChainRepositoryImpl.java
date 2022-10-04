package com.ear.core.repository;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.ChainMapper;

@Repository
public class ChainRepositoryImpl extends GenericRepository implements ChainRepository {

	@Override
	public Integer getIdChain(String nameChain) {
		ChainMapper mapper = super.getSqlSession().getMapper( ChainMapper.class );
		return mapper.getIdChain(nameChain);
	}


}
