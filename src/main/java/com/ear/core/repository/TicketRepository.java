package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;

public interface TicketRepository {

	public void createdTicket(TicketRequest ticketRequest);

	public List<TicketModel> getTickets();

	public TicketModel getTicket(Integer idTicket);

	public List<PriceMaterialModel> getPricesForCalculated(CalculatedTicketRequest calculatedTicketRequest);

	public void insertTicketForCalcutated(CalculatedTicketRequest calculatedTicketRequest);

	public Integer getIdTicket();

	public void updatePriceCalcutatedTicket(CalculatedTicketRequest calculatedTicketRequest);

	public PriceMaterialModel getPriceForCalculated(CalculatedTicketRequest calculatedTicketRequest);

	public String getFolioTicket(Integer idTicket);

	public void validateTicket(TicketRequest ticketRequest);

	public void deletedTicket(Integer idTicket);

}
