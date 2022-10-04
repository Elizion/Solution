package com.ear.core.payload;

import java.util.Date;

public class TicketRequest {

	private Integer idTicket;
	private String statusTicket;
	private String folio; 
	private String badge; 
	private String badgeSmurfit; 
	private Integer idStore;
	private Integer idMaterial; 
	private String carrier;
	private Double weight;
	private Double weigthOk;
	private String puch;
	private String operator;
	private Date date;
	private String observations;
	private String codeStatus;
	
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
	 * @return the statusTicket
	 */
	public String getStatusTicket() {
		return statusTicket;
	}
	/**
	 * @param statusTicket the statusTicket to set
	 */
	public void setStatusTicket(String statusTicket) {
		this.statusTicket = statusTicket;
	}
	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	/**
	 * @return the badge
	 */
	public String getBadge() {
		return badge;
	}
	/**
	 * @param badge the badge to set
	 */
	public void setBadge(String badge) {
		this.badge = badge;
	}
	/**
	 * @return the badgeSmurfit
	 */
	public String getBadgeSmurfit() {
		return badgeSmurfit;
	}
	/**
	 * @param badgeSmurfit the badgeSmurfit to set
	 */
	public void setBadgeSmurfit(String badgeSmurfit) {
		this.badgeSmurfit = badgeSmurfit;
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
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @return the weigthOk
	 */
	public Double getWeigthOk() {
		return weigthOk;
	}
	/**
	 * @param weigthOk the weigthOk to set
	 */
	public void setWeigthOk(Double weigthOk) {
		this.weigthOk = weigthOk;
	}
	/**
	 * @return the puch
	 */
	public String getPuch() {
		return puch;
	}
	/**
	 * @param puch the puch to set
	 */
	public void setPuch(String puch) {
		this.puch = puch;
	}
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
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
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}
	/**
	 * @param observations the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
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
	
}
