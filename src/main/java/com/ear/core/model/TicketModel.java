package com.ear.core.model;

import java.util.Date;

public class TicketModel {

	private Integer id;
	private String folio;
	private String badge; 
	private String badgeSmurfit; 
	private Integer idStore;
	private String codeStore;
	private String nameStore;
	private Integer idMaterial;
	private String codeMaterial;
	private String nameMaterial;
	private String carrier;
	private Double weight;
	private Double weigthOk; 
	private String operator;
	private Date date;	
	private String dateAsString;
	private String observations;
	private String ticketStatus;
	private Double priceCalculated;
	private String codeStatus;
	private Date createdAt;
	private Date modifiedAt;
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
	 * @return the codeStore
	 */
	public String getCodeStore() {
		return codeStore;
	}
	/**
	 * @param codeStore the codeStore to set
	 */
	public void setCodeStore(String codeStore) {
		this.codeStore = codeStore;
	}
	/**
	 * @return the nameStore
	 */
	public String getNameStore() {
		return nameStore;
	}
	/**
	 * @param nameStore the nameStore to set
	 */
	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
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
	 * @return the codeMaterial
	 */
	public String getCodeMaterial() {
		return codeMaterial;
	}
	/**
	 * @param codeMaterial the codeMaterial to set
	 */
	public void setCodeMaterial(String codeMaterial) {
		this.codeMaterial = codeMaterial;
	}
	/**
	 * @return the nameMaterial
	 */
	public String getNameMaterial() {
		return nameMaterial;
	}
	/**
	 * @param nameMaterial the nameMaterial to set
	 */
	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
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
	 * @return the dateAsString
	 */
	public String getDateAsString() {
		return dateAsString;
	}
	/**
	 * @param dateAsString the dateAsString to set
	 */
	public void setDateAsString(String dateAsString) {
		this.dateAsString = dateAsString;
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
	 * @return the ticketStatus
	 */
	public String getTicketStatus() {
		return ticketStatus;
	}
	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
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
	
	
	
}
