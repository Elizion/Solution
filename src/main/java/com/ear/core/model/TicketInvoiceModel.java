package com.ear.core.model;

import java.util.List;

public class TicketInvoiceModel {

	private TicketModel ticket;	
	private List<InvoiceExcelModel> listInvoiceExcel;
	private Integer totalInvoice;
	/**
	 * @return the ticket
	 */
	public TicketModel getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(TicketModel ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return the listInvoiceExcel
	 */
	public List<InvoiceExcelModel> getListInvoiceExcel() {
		return listInvoiceExcel;
	}
	/**
	 * @param listInvoiceExcel the listInvoiceExcel to set
	 */
	public void setListInvoiceExcel(List<InvoiceExcelModel> listInvoiceExcel) {
		this.listInvoiceExcel = listInvoiceExcel;
	}
	/**
	 * @return the totalInvoice
	 */
	public Integer getTotalInvoice() {
		return totalInvoice;
	}
	/**
	 * @param totalInvoice the totalInvoice to set
	 */
	public void setTotalInvoice(Integer totalInvoice) {
		this.totalInvoice = totalInvoice;
	}
		
}
