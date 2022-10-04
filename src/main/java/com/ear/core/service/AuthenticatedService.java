package com.ear.core.service;

import java.util.List;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.payload.UserRequest;

public interface AuthenticatedService {

	public List<AuthenticatedModel> getListAuthenticatedByUuidUser(Integer idUser);

	public AuthenticatedModel getDefaultUserRole();

	public void createListAuthenticated(UserRequest userRequest);

}
