package com.ear.core.model;

import java.util.Date;

public class ActivityModel {

	private String title;
	private String message;
	private Integer idUser;
	private String fullNameUser;
	private String module;	
	private Date createdAt;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getFullNameUser() {
		return fullNameUser;
	}

	public void setFullNameUser(String fullNameUser) {
		this.fullNameUser = fullNameUser;
	}		

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
