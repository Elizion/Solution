package com.ear.core.model;

import java.util.Date;

public class UserAuthenticatedModel {
	
	private Integer idUser;
	private Integer idAuthenticated;
	private String name;
	private String codeStatus;
	private Date createdAt;
	private Date modifiedAt;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdAuthenticated() {
		return idAuthenticated;
	}
	public void setIdAuthenticated(Integer idAuthenticated) {
		this.idAuthenticated = idAuthenticated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
