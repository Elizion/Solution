package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;

@Mapper
public interface TicketMapper {

	public void createdTicket(@Param("ticketRequest") TicketRequest ticketRequest);

	public List<TicketModel> getTickets();

	public TicketModel getTicket(@Param("idTicket") Integer idTicket);

	public List<PriceMaterialModel> getPricesForCalculated(@Param("calculatedTicketRequest") CalculatedTicketRequest calculatedTicketRequest);
	
	public PriceMaterialModel getPriceForCalculated(@Param("calculatedTicketRequest") CalculatedTicketRequest calculatedTicketRequest);

	public void insertTicketForCalcutated(@Param("calculatedTicketRequest") CalculatedTicketRequest calculatedTicketRequest);
	
	public Double getPriceCalculated(@Param("calculatedTicketRequest") CalculatedTicketRequest calculatedTicketRequest);

	public Integer getIdTicket();

	public void updatePriceCalcutatedTicket(@Param("calculatedTicketRequest") CalculatedTicketRequest calculatedTicketRequest);

	public String getFolioTicket(@Param("idTicket") Integer idTicket);

	public void getFolioTicket(TicketRequest ticketRequest);

	public void validateTicket(@Param("ticketRequest") TicketRequest ticketRequest);

	public void deletedTicket(@Param("idTicket") Integer idTicket);

}
