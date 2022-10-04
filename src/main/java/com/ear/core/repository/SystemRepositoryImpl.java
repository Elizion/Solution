package com.ear.core.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.SystemMapper;

@Repository
public class SystemRepositoryImpl extends GenericRepository implements SystemRepository  {

	@Override
	public Date getDateSystem() {
		SystemMapper mapper = super.getSqlSession().getMapper( SystemMapper.class );
		return mapper.getDateSystem();
	}
	
	@Override
	public Integer getIdUser() {
		SystemMapper mapper = super.getSqlSession().getMapper( SystemMapper.class );
		return mapper.getIdUser();
	}
	
}
