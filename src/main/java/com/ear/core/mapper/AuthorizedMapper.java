package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserAuthorizedModel;

@Mapper
public interface AuthorizedMapper {	

	public List<AuthorizedModel> getListAuthorizedByUuidUser(@Param("idUser") Integer idUser);

	public void createListAuthorized(@Param("listUserAuthorized") List<UserAuthorizedModel> listUserAuthorized);

	public List<AuthorizedModel> getListAuthorizedActives();

	public AuthorizedModel getDefaultUserPermission();

}
