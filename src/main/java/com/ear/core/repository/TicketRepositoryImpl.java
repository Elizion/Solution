package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.TicketMapper;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;

@Repository
public class TicketRepositoryImpl extends GenericRepository implements TicketRepository {

	@Override
	public void createdTicket(TicketRequest ticketRequest) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		mapper.createdTicket(ticketRequest);
	}

	@Override
	public List<TicketModel> getTickets() {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		return mapper.getTickets();		
	}

	@Override
	public TicketModel getTicket(Integer idTicket) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		return mapper.getTicket(idTicket);	
	}

	@Override
	public List<PriceMaterialModel> getPricesForCalculated(CalculatedTicketRequest calculatedTicketRequest) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		return mapper.getPricesForCalculated(calculatedTicketRequest);
	}

	@Override
	public void insertTicketForCalcutated(CalculatedTicketRequest calculatedTicketRequest) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		mapper.insertTicketForCalcutated(calculatedTicketRequest);
	}

	@Override
	public Integer getIdTicket() {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		return mapper.getIdTicket();
	}

	@Override
	public void updatePriceCalcutatedTicket(CalculatedTicketRequest calculatedTicketRequest) {		
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		mapper.updatePriceCalcutatedTicket(calculatedTicketRequest);	
	}

	@Override
	public PriceMaterialModel getPriceForCalculated(CalculatedTicketRequest calculatedTicketRequest) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		PriceMaterialModel priceMaterialModel = mapper.getPriceForCalculated(calculatedTicketRequest);
		return priceMaterialModel;
	}

	@Override
	public String getFolioTicket(Integer idTicket) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		return mapper.getFolioTicket(idTicket);	
	}

	@Override
	public void validateTicket(TicketRequest ticketRequest) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		mapper.validateTicket(ticketRequest);
	}

	@Override
	public void deletedTicket(Integer idTicket) {
		TicketMapper mapper = super.getSqlSession().getMapper( TicketMapper.class );
		mapper.deletedTicket(idTicket);	
	}
		
}
