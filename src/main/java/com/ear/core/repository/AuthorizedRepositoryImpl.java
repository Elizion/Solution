package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.AuthorizedMapper;
import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserAuthorizedModel;

@Repository
public class AuthorizedRepositoryImpl extends GenericRepository implements AuthorizedRepository  {

	@Override
	public List<AuthorizedModel> getListAuthorizedByUuidUser(Integer idUser) {
		AuthorizedMapper mapper = super.getSqlSession().getMapper( AuthorizedMapper.class );
		return mapper.getListAuthorizedByUuidUser(idUser);
	}

	@Override
	public void createListAuthorized(List<UserAuthorizedModel> lisUserAuthorizedModel) {
		AuthorizedMapper mapper = super.getSqlSession().getMapper( AuthorizedMapper.class );
		mapper.createListAuthorized(lisUserAuthorizedModel);			
	}

	@Override
	public AuthorizedModel getDefaultUserPermission() {
		AuthorizedMapper mapper = super.getSqlSession().getMapper( AuthorizedMapper.class );
		return mapper.getDefaultUserPermission();
	}
	
}
