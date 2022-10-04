package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.UserAuthenticatedModel;

public interface AuthenticatedMapper {

	public List<AuthenticatedModel> getListAuthenticatedByUuidUser(@Param("idUser") Integer idUser);

	public AuthenticatedModel getDefaultUserRole();

	public void createListAuthenticated(@Param("listUserAuthenticated") List<UserAuthenticatedModel> listUserAuthenticated);
	
}
