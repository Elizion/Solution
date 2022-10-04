package com.ear.core.payload;

import java.util.Date;

public class CalculatedTicketRequest {

	private Integer idTicket;
	private Integer idStore;
	private Integer idMaterial;
	private Date date;
	private Double priceCalculated;
	/**
	 * @return the idTicket
	 */
	public Integer getIdTicket() {
		return idTicket;
	}
	/**
	 * @param idTicket the idTicket to set
	 */
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
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
	 * @param idMaterial the idMaterial to set
	 */
	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
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
	 * @return the priceCalculated
	 */
	public Double getPriceCalculated() {
		return priceCalculated;
	}
	/**
	 * @param priceCalculated the priceCalculated to set
	 */
	public void setPriceCalculated(Double priceCalculated) {
		this.priceCalculated = priceCalculated;
	}
		
}
