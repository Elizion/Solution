package com.ear.core.payload;

public class ActivityRequest {

	private String title;
	private String message;
	private Integer idUser;
	private String fullNameUser;
	private String module;	

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
	
}
