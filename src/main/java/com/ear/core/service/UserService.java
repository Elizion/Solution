package com.ear.core.service;

import java.io.IOException;
import java.util.List;

import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;

public interface UserService {

	public UserModel getUserByEmail(String email);

	public UserRequest createUser(UserRequest userRequest) throws IOException;

	public List<UserModel> getUserActives();

	public void desactivatedUserByEmail(Integer id);

	public void activatedUserByEmail(Integer id);

}
