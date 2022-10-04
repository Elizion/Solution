package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.AuthenticatedMapper;
import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.UserAuthenticatedModel;

@Repository
public class AuthenticatedRepositoryImpl extends GenericRepository implements AuthenticatedRepository {

	@Override
	public List<AuthenticatedModel> getListAuthenticatedByUuidUser(Integer idUser) {
		AuthenticatedMapper mapper = super.getSqlSession().getMapper( AuthenticatedMapper.class );
		return mapper.getListAuthenticatedByUuidUser(idUser);
	}

	@Override
	public AuthenticatedModel getDefaultUserRole() {
		AuthenticatedMapper mapper = super.getSqlSession().getMapper( AuthenticatedMapper.class );
		return mapper.getDefaultUserRole();
	}
	
	@Override
	public void createListAuthenticated(List<UserAuthenticatedModel> listUserAuthenticatedModel) {
		AuthenticatedMapper mapper = super.getSqlSession().getMapper( AuthenticatedMapper.class );
		mapper.createListAuthenticated(listUserAuthenticatedModel);		
	}
	
}
