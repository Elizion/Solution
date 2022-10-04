package com.ear.core.payload;

import java.util.Date;
import java.util.List;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.AuthorizedModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequest {
	
	private Integer id;
	private String name;
	private String lastName;
	private String email;
	@JsonIgnore
	private String password;
	private String phone;
	private Boolean gender;
	private Date bornDate;
	private Boolean isEnabled;
	private String picture;
	
	private List<AuthenticatedModel> listAuthenticated;	
	private List<AuthorizedModel> listAuthorized;
	
	public List<AuthenticatedModel> getListAuthenticated() {
		return listAuthenticated;
	}
	public void setListAuthenticated(List<AuthenticatedModel> listAuthenticated) {
		this.listAuthenticated = listAuthenticated;
	}
	public List<AuthorizedModel> getListAuthorized() {
		return listAuthorized;
	}
	public void setListAuthorized(List<AuthorizedModel> listAuthorized) {
		this.listAuthorized = listAuthorized;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
