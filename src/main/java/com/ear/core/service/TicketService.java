package com.ear.core.service;

import java.util.List;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;

public interface TicketService {

	public void createdTicket(TicketRequest ticketRequest);

	public List<TicketModel> getTickets();

	public PriceMaterialModel calculatedTicket(CalculatedTicketRequest calculatedTicketRequest);

	public void calculateMassive();

	public String getFolioTicket(Integer idTicket);

	public void validateTicket(TicketRequest ticketRequest);

	public void deletedTicket(Integer idTicket);


}
