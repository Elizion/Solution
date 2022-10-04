package com.ear.core.repository;

import java.util.List;
import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserAuthorizedModel;

public interface AuthorizedRepository {	

	public List<AuthorizedModel> getListAuthorizedByUuidUser(Integer idUser);

	public void createListAuthorized(List<UserAuthorizedModel> listUserAuthorized);

	public AuthorizedModel getDefaultUserPermission();

}
