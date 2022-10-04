package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;

public interface UserRepository {

	public void createUser(UserRequest userRequest);
	
	public UserModel getUserByEmail(String email);

	public List<UserModel> getUserActives();

	public void desactivatedUserByEmail(Integer id);

	public void activatedUserByEmail(Integer id);

}
