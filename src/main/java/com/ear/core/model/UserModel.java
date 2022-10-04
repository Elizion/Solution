package com.ear.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class UserModel {

	private Integer id;
	private String picture;
	private String name;
	private String lastName;
	private String email;
	@JsonIgnore
	private String password;
	private String phone;
	private Boolean gender;
	private Date bornDate;
	private Boolean isEnabled;
	private String codeStatus;
	private Date createdAt;
	private Date modifiedAt;
	
	private List<AuthenticatedModel> listAuthenticated;	
	private List<AuthorizedModel> listAuthorized;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public String getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
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
	
}

