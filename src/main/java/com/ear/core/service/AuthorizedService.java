package com.ear.core.service;

import java.util.List;

import com.ear.core.model.AuthorizedModel;
import com.ear.core.payload.UserRequest;

public interface AuthorizedService {

	public List<AuthorizedModel> getListAuthorizedByUuidUser(Integer idUser);

	public void createListAuthorized(UserRequest userRequest);

	public AuthorizedModel getDefaultUserPermission();
	
}
