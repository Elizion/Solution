package com.ear.core.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;
import com.ear.core.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void createdTicket(TicketRequest ticketRequest) {		
		this.ticketRepository.createdTicket(ticketRequest);
	}

	@Override
	public List<TicketModel> getTickets() {		
		
		List<TicketModel> listTicketModel = this.ticketRepository.getTickets();  		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyy");		
		String dateAsString = null;		
		
		for(TicketModel data: listTicketModel) {			
			if(data.getDate() != null) {
				dateAsString = sdf.format(data.getDate());
				data.setDateAsString(dateAsString);	
			}			
		}
		
		return listTicketModel;
		
	}

	@Override
	public PriceMaterialModel calculatedTicket(CalculatedTicketRequest calculatedTicketRequest) {
				
		PriceMaterialModel priceMaterialModel = new PriceMaterialModel();
		
		Integer idTicket = calculatedTicketRequest.getIdTicket();
		Integer idStore = calculatedTicketRequest.getIdStore();
		Integer idMaterial = calculatedTicketRequest.getIdMaterial();
		Date dateTicket = calculatedTicketRequest.getDate();

		TicketModel ticketModel = this.ticketRepository.getTicket(idTicket);
		
		System.out.println("Id ticket " + idTicket);
		System.out.println("Id tienda " + idStore);
		System.out.println("Id material " + idMaterial);
		System.out.println("Fecha ticket " + dateTicket);
		System.out.println("Peso aceptado " + ticketModel.getWeigthOk());	
		
		Double weightOk = ticketModel.getWeigthOk();	
		Double weightCalculated = (weightOk / 1000.00);
		
		System.out.println("Peso calculado " + weightCalculated);
	
		this.ticketRepository.updatePriceCalcutatedTicket(calculatedTicketRequest);
		
		return priceMaterialModel;		
		
	}

	@Override
	public void calculateMassive() {
		
		List<TicketModel> listTicketModel = this.ticketRepository.getTickets();  				
		
		String folio = null;
		boolean isValidate = false; 
		
		for(TicketModel data: listTicketModel) {			
			
			isValidate = this.ticketCandidate(data);
			folio = data.getFolio();
			
			if(isValidate) {
				
				//System.out.println("El ticket con folio " + folio + " si es candidato para ser calculado");
				
			} else {
				
				System.out.println("El ticket con folio " + folio + " no es candidato para ser calculado");
				
			}
			/*
			CalculatedTicketRequest calculatedTicketRequest = new CalculatedTicketRequest();
			
			calculatedTicketRequest.setIdTicket(data.getId());
			calculatedTicketRequest.setIdStore(data.getIdStore());
			calculatedTicketRequest.setIdMaterial(data.getIdMaterial());			
			calculatedTicketRequest.setDate(data.getDate());
			
			Double weightOk = data.getWeigthOk();
			Double weightCalculated = (weightOk / 1000.00);
			
			PriceMaterialModel priceMaterialModel = this.ticketRepository.getPriceForCalculated(calculatedTicketRequest);
			
			Double priceCalculated = priceMaterialModel.getPrice();						
			Double priceFinal = (weightCalculated * priceCalculated);
			calculatedTicketRequest.setPriceCalculated(priceFinal);
			
			//this.ticketRepository.updatePriceCalcutatedTicket(calculatedTicketRequest);
			*/
			
		}				
		
	}

	private boolean ticketCandidate(TicketModel data) {

		boolean isValidate = false; 
		
		String folio = data.getFolio();
		Integer idStore = data.getIdStore();
		Integer idMaterial = data.getIdMaterial();
		Double weigthOk = data.getWeigthOk();
		Date dateTikect = data.getDate();
		//String codeStatus = data.getCodeStatus();
		Date dateNow = new Date();
		
		if(idStore == null || idMaterial == null || weigthOk == null || dateTikect == null || folio.equals(null) || dateTikect.after(dateNow)) {			
			isValidate = false;
		} else {
			isValidate = true;
		}
		
		return isValidate;
	}

	@Override
	public String getFolioTicket(Integer idTicket) {
		return this.ticketRepository.getFolioTicket(idTicket);
	}

	@Override
	public void validateTicket(TicketRequest ticketRequest) {
		this.ticketRepository.validateTicket(ticketRequest);
	}

	@Override
	public void deletedTicket(Integer idTicket) {
		this.ticketRepository.deletedTicket(idTicket);
	}

}
