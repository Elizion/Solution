package com.ear.core.payload;

import java.util.Date;

public class StorePriceRequest {
	
	private Integer idPrice;
	private Integer idStore;
	private Integer idStoreType;
	private Integer idMaterial;
	private Integer idUnit;
	private Date date;
	private Double price;
	
	
	/**
	 * @return the idPrice
	 */
	public Integer getIdPrice() {
		return idPrice;
	}
	/**
	 * @param idPrice the idPrice to set
	 */
	public void setIdPrice(Integer idPrice) {
		this.idPrice = idPrice;
	}
	/**
	 * @return the idStore
	 */
	public Integer getIdStore() {
		return idStore;
	}
	/**
	 * @param idStore the idStore to set
	 */
	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}
	/**
	 * @return the idMaterial
	 */
	
	public Integer getIdMaterial() {
		return idMaterial;
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
	 * @param idMaterial the idMaterial to set
	 */
	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}
	/**
	 * @return the idUnit
	 */
	public Integer getIdUnit() {
		return idUnit;
	}
	/**
	 * @param idUnit the idUnit to set
	 */
	public void setIdUnit(Integer idUnit) {
		this.idUnit = idUnit;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
