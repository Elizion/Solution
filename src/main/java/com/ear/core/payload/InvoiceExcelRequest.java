package com.ear.core.payload;

import java.util.Date;

public class InvoiceExcelRequest {

	private Integer section;
	private String folioTicket;
	private String codeStore;
	private String location;
	private String customer;
	private String material;
	private String plant;
	private String aml;
	private Date dateCollection;
	private Double quantity;
	private Double price;
	private String numberInvoice;
	
	/**
	 * @return the section
	 */
	public Integer getSection() {
		return section;
	}
	/**
	 * @param section the section to set
	 */
	public void setSection(Integer section) {
		this.section = section;
	}
	/**
	 * @return the folioTicket
	 */
	public String getFolioTicket() {
		return folioTicket;
	}
	/**
	 * @param folioTicket the folioTicket to set
	 */
	public void setFolioTicket(String folioTicket) {
		this.folioTicket = folioTicket;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}
	/**
	 * @param plant the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}
	/**
	 * @return the aml
	 */
	public String getAml() {
		return aml;
	}
	/**
	 * @param aml the aml to set
	 */
	public void setAml(String aml) {
		this.aml = aml;
	}
	/**
	 * @return the dateCollection
	 */
	public Date getDateCollection() {
		return dateCollection;
	}
	/**
	 * @param dateCollection the dateCollection to set
	 */
	public void setDateCollection(Date dateCollection) {
		this.dateCollection = dateCollection;
	}
	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
	/**
	 * @return the numberInvoice
	 */
	public String getNumberInvoice() {
		return numberInvoice;
	}
	/**
	 * @param numberInvoice the numberInvoice to set
	 */
	public void setNumberInvoice(String numberInvoice) {
		this.numberInvoice = numberInvoice;
	}
	
}
