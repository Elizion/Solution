package com.ear.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserAuthorizedModel;
import com.ear.core.payload.UserRequest;
import com.ear.core.repository.AuthorizedRepository;

@Service
public class AuthorizedServiceImpl implements AuthorizedService {
	
	@Autowired
	private AuthorizedRepository authorizedRepository;

	@Override
	public List<AuthorizedModel> getListAuthorizedByUuidUser(Integer idUser) {		
		return this.authorizedRepository.getListAuthorizedByUuidUser(idUser);
	}
	
	@Override
	public AuthorizedModel getDefaultUserPermission() {
		return this.authorizedRepository.getDefaultUserPermission();
	}
	
	@Override
	public void createListAuthorized(UserRequest userRequest) {
		
		List<AuthorizedModel> listAuthorized = userRequest.getListAuthorized();
		List<UserAuthorizedModel> listUserAuthorized = new ArrayList<UserAuthorizedModel>();							
		
		Integer idUser = userRequest.getId();
		
		for(AuthorizedModel authorized: listAuthorized) {					
			
			UserAuthorizedModel itemAuthorized = new UserAuthorizedModel();			
			
			itemAuthorized.setIdUser(idUser);
			itemAuthorized.setIdAuthorized(authorized.getId());
			listUserAuthorized.add(itemAuthorized);
			
		}			
		
		this.authorizedRepository.createListAuthorized(listUserAuthorized);
		
	}
	
}
