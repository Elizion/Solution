package com.ear.core.model;

import java.util.Date;
import java.util.List;

public class StoreModel {

	private Integer id;
	private Integer idChain;
	private String nameChain;
	private Integer idStoreType;
	private String nameStoreType;
	private String determinant;
	private String name;
	private Integer code;
	private String codeStatus;
	private Date createdAt;
	private Date modifiedAt;	
	
	private List<PriceMaterialModel> listPriceMaterialModel;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the idChain
	 */
	public Integer getIdChain() {
		return idChain;
	}

	/**
	 * @param idChain the idChain to set
	 */
	public void setIdChain(Integer idChain) {
		this.idChain = idChain;
	}

	/**
	 * @return the nameChain
	 */
	public String getNameChain() {
		return nameChain;
	}

	/**
	 * @param nameChain the nameChain to set
	 */
	public void setNameChain(String nameChain) {
		this.nameChain = nameChain;
	}

	/**
	 * @return the idStoreType
	 */
	public Integer getIdStoreType() {
		return idStoreType;
	}

	/**
	 * @param idStoreType the idStoreType to set
	 */
	public void setIdStoreType(Integer idStoreType) {
		this.idStoreType = idStoreType;
	}

	/**
	 * @return the nameStoreType
	 */
	public String getNameStoreType() {
		return nameStoreType;
	}

	/**
	 * @param nameStoreType the nameStoreType to set
	 */
	public void setNameStoreType(String nameStoreType) {
		this.nameStoreType = nameStoreType;
	}

	/**
	 * @return the determinant
	 */
	public String getDeterminant() {
		return determinant;
	}

	/**
	 * @param determinant the determinant to set
	 */
	public void setDeterminant(String determinant) {
		this.determinant = determinant;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the codeStatus
	 */
	public String getCodeStatus() {
		return codeStatus;
	}

	/**
	 * @param codeStatus the codeStatus to set
	 */
	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the modifiedAt
	 */
	public Date getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * @param modifiedAt the modifiedAt to set
	 */
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * @return the listPriceMaterialModel
	 */
	public List<PriceMaterialModel> getListPriceMaterialModel() {
		return listPriceMaterialModel;
	}

	/**
	 * @param listPriceMaterialModel the listPriceMaterialModel to set
	 */
	public void setListPriceMaterialModel(List<PriceMaterialModel> listPriceMaterialModel) {
		this.listPriceMaterialModel = listPriceMaterialModel;
	}
				
}
