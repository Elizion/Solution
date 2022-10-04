package com.ear.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.UserAuthenticatedModel;
import com.ear.core.payload.UserRequest;
import com.ear.core.repository.AuthenticatedRepository;

@Service
public class AuthenticatedServiceImpl implements AuthenticatedService {
	
	@Autowired
	private AuthenticatedRepository authenticatedRepository;
	
	@Override
	public List<AuthenticatedModel> getListAuthenticatedByUuidUser(Integer idUser) {
		return this.authenticatedRepository.getListAuthenticatedByUuidUser(idUser);
	}

	@Override
	public AuthenticatedModel getDefaultUserRole() {
		return this.authenticatedRepository.getDefaultUserRole();
	}

	@Override
	public void createListAuthenticated(UserRequest userRequest) {
		
		List<AuthenticatedModel> listAuthenticated = userRequest.getListAuthenticated();
		List<UserAuthenticatedModel> listUserAuthenticated = new ArrayList<UserAuthenticatedModel>();							
		
		Integer idUser = userRequest.getId();
		
		for(AuthenticatedModel authenticated: listAuthenticated) {					
			
			UserAuthenticatedModel itemAuthenticated = new UserAuthenticatedModel();			
			
			itemAuthenticated.setIdUser(idUser);
			itemAuthenticated.setIdAuthenticated(authenticated.getId());
			listUserAuthenticated.add(itemAuthenticated);
			
		}			
		
		this.authenticatedRepository.createListAuthenticated(listUserAuthenticated);
		
	}
		
}
