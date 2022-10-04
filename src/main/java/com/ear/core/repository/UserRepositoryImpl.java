package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.UserMapper;
import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;

@Repository
public class UserRepositoryImpl extends GenericRepository implements UserRepository {

	@Override
	public void createUser(UserRequest userRequest) {
		UserMapper mapper = super.getSqlSession().getMapper( UserMapper.class );
		mapper.createUser(userRequest);
	}
	
	@Override
	public UserModel getUserByEmail(String email) {	
		UserMapper mapper = super.getSqlSession().getMapper( UserMapper.class );
		return mapper.getUserByEmail(email);
	}

	@Override
	public List<UserModel> getUserActives() {
		UserMapper mapper = super.getSqlSession().getMapper( UserMapper.class );
		return mapper.getUserActives();
	}

	@Override
	public void desactivatedUserByEmail(Integer id) {
		UserMapper mapper = super.getSqlSession().getMapper( UserMapper.class );
		mapper.desactivatedUserByEmail(id);
	}

	@Override
	public void activatedUserByEmail(Integer id) {
		UserMapper mapper = super.getSqlSession().getMapper( UserMapper.class );
		mapper.activatedUserByEmail(id);		
	}
		
}
