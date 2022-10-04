package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.UserAuthenticatedModel;

public interface AuthenticatedRepository {

	public List<AuthenticatedModel> getListAuthenticatedByUuidUser(Integer idUser);

	public AuthenticatedModel getDefaultUserRole();
	
	public void createListAuthenticated(List<UserAuthenticatedModel> listUserAuthenticatedModel);
	
}
