package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;

@Mapper
public interface UserMapper {
	
	public UserModel getUserByEmail(@Param("email") String email);

	public void createUser(@Param("userRequest") UserRequest userRequest);

	public List<UserModel> getUserActives();

	public void desactivatedUserByEmail(@Param("id") Integer id);

	public void activatedUserByEmail(@Param("id") Integer id);

}
