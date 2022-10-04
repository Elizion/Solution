package com.ear.core.model;

import java.util.Date;

public class UserAuthorizedModel {
	
	private Integer id;
	private Integer idUser;
	private Integer idAuthorized;
	private String name;
	private String codeStatus;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdAuthorized() {
		return idAuthorized;
	}
	public void setIdAuthorized(Integer idAuthorized) {
		this.idAuthorized = idAuthorized;
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
