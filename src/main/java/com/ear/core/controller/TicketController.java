package com.ear.core.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ear.core.config.SolutionConst;
import com.ear.core.exception.SolutionException;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.CalculatedTicketRequest;
import com.ear.core.payload.TicketRequest;
import com.ear.core.service.MaterialService;
import com.ear.core.service.StoreService;
import com.ear.core.service.TicketService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

	public final static Logger logger = Logger.getLogger(TicketController.class);

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private StoreService storeService;
		
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value = "/upload/file", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> chargeFileTickets(@RequestParam("file") MultipartFile file) throws ParseException {

		String nameFile = file.getOriginalFilename();		
		List<String> listDates = new ArrayList<>();
		String nameSheet = null;
		
		try {
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Workbook workbook = WorkbookFactory.create(file.getInputStream());				
			
			for (int i=0; i< workbook.getNumberOfSheets(); i++) {	
				
				Sheet sheet = workbook.getSheetAt(i);
				nameSheet = sheet.getSheetName();			
				System.out.println(nameSheet);
				
				Row row = null;
				
				int statusTicketCol = 0;
				int numberTicketCol = 2;
				int badgeCol 		= 3;
				int codeStoreCol 	= 4;
				int nameStoreCol 	= 5;
				int codeMaterialCol = 6;
				int nameMaterialCol = 7;
				int puchCol 		= 8;
				int weigthCol 		= 9;
				int operatorCol 	= 10;
				int dateStampCol 	= 11;
				int ovservationsCol = 12;
				
				String valueStatusTicket = null;
				String valueNumberTicket = null;
				String valueBadge 		 = null;
				String valueCodeStore 	 = null;
				String valueNameStore 	 = null;
				String valueCodeMaterial = null;
				String valueNameMaterial = null;
				String valuePuch 		 = null;
				String valueWeigth 	     = null;
				String valueOpertator 	 = null;
				String valueDateStamp 	 = null;
				String valueObservations = null;

				Integer codeStore    = null;
				Double weigth     	 = null;				
				
				int cont = 1;
				
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					
					TicketRequest ticketRequest = new TicketRequest();
					
					row = sheet.getRow(rowIndex);
					
					if (row != null) {					
						
						Cell cellStatusTicket 	= row.getCell(statusTicketCol);
						Cell cellNumberTicket 	= row.getCell(numberTicketCol);
						Cell cellBadge 			= row.getCell(badgeCol);
						Cell cellCodeStore 		= row.getCell(codeStoreCol);
						Cell cellNameStore 		= row.getCell(nameStoreCol);
						Cell cellCodeMaterial 	= row.getCell(codeMaterialCol);
						Cell cellNameMaterial 	= row.getCell(nameMaterialCol);
						Cell cellPuch 			= row.getCell(puchCol);
						Cell cellWeigth 		= row.getCell(weigthCol);
						Cell cellOperator 		= row.getCell(operatorCol);
						Cell cellDateStamp 		= row.getCell(dateStampCol);
						Cell cellObservations 	= row.getCell(ovservationsCol);						
						
						valueStatusTicket = cellStatusTicket.getStringCellValue();
						valueNumberTicket = cellNumberTicket.getStringCellValue();		
						
						valueBadge = cellBadge.getStringCellValue();

						if(valueBadge.equals("")) {
							valueBadge = "null";			
						}
						
						valueCodeStore = cellCodeStore.getStringCellValue();
						
						if(valueCodeStore.equals("")) {
							valueCodeStore = "0";			
						}
						
						codeStore = Integer.parseInt(valueCodeStore.trim());						
						
						valueNameStore = cellNameStore.getStringCellValue();
						
						if(valueNameStore.equals("")) {
							valueNameStore = "null";			
						}
						
						valueCodeMaterial = cellCodeMaterial.getStringCellValue();

						if(valueCodeMaterial.equals("")) {
							valueCodeMaterial = "null";			
						}
						
						valueNameMaterial = cellNameMaterial.getStringCellValue();	
						
						if(valueNameMaterial.equals("")) {
							valueNameMaterial = "null";			
						}
						
						valuePuch = cellPuch.getStringCellValue();	
						
						if(valuePuch.equals("")) {
							valuePuch = "0";
						}
						
						valueWeigth = cellWeigth.getStringCellValue();
						
						if(valueWeigth.equals("")) {
							valueWeigth = "0";							
						}
						
						weigth = Double.parseDouble(valueWeigth);						
						valueOpertator = cellOperator.getStringCellValue();
						
						if(valueOpertator.equals("")) {
							valueOpertator = "null";							
						}
						
						valueDateStamp = cellDateStamp.getStringCellValue();

						if(valueDateStamp.equals("")) {
							valueDateStamp = "01/01/1999";
						}
						
						valueObservations = cellObservations.getStringCellValue();
						
						if(valueObservations.equals("")) {
							valueObservations = "null";							
						}
						
						Integer idStore = this.storeService.getIdStoreByCode(codeStore);
						Integer idMaterial  = this.materialService.getIdMaterial(valueNameMaterial.trim());
						Date date = sdf.parse(valueDateStamp);
						
						ticketRequest.setStatusTicket(valueStatusTicket);
						ticketRequest.setFolio(valueNumberTicket);
						ticketRequest.setBadge(valueBadge);
						ticketRequest.setBadgeSmurfit(valueBadge);
						ticketRequest.setIdStore(idStore);
						ticketRequest.setIdMaterial(idMaterial);
						ticketRequest.setCarrier("Guillermo Casarrubias");
						ticketRequest.setWeight(weigth);
						ticketRequest.setWeigthOk(weigth);
						ticketRequest.setPuch(valuePuch);
						ticketRequest.setOperator(valueOpertator);										
						ticketRequest.setDate(date);
						ticketRequest.setObservations(valueObservations);
						
						System.out.println(cont + " " + valueStatusTicket + " " + valueNumberTicket + " " + valueBadge + " " + codeStore + " " + valueNameStore + " " + valueCodeMaterial + " " + valuePuch + " " + weigth + " " + valueOpertator + " " + date);
						cont ++;
							
						this.ticketService.createdTicket(ticketRequest);
						
					}
					
				}
				
			}			
						
		} catch (Exception e) {
			
			System.err.println(e);
			return ResponseHandler.generateResponseModel(SolutionConst.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, "Error al procesar el archivo " + nameFile);
			
		}

		return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listDates);
		
	}
	
	@PostMapping("calculate/massive")
	public ResponseEntity<Object> calculateMassive() {				
		
		try {
			
			this.ticketService.calculateMassive();
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, "Calculo masivo generado correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@PostMapping("calculated")
	public ResponseEntity<Object> calculatedTicket(@RequestBody CalculatedTicketRequest calculatedTicketRequest) {				
		
		try {
			
			PriceMaterialModel priceMaterialModel = this.ticketService.calculatedTicket(calculatedTicketRequest);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, priceMaterialModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@GetMapping("get/actives")
	public ResponseEntity<Object> getTickets() {				
		
		try {
							
			List<TicketModel> listTicketModel = this.ticketService.getTickets();
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listTicketModel);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@PutMapping("validate")
	public ResponseEntity<Object> validateTicket(@RequestBody TicketRequest ticketRequest) {				
		
		try {
							
			this.ticketService.validateTicket(ticketRequest);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "Ticket validado correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@PostMapping("created")
	public ResponseEntity<Object> createdTicket(@RequestBody TicketRequest ticketRequest) {				
		
		try {
			
			ticketRequest.setStatusTicket("OCUPADO");
			
			System.out.println(ticketRequest.getStatusTicket());
			System.out.println(ticketRequest.getFolio());
			System.out.println(ticketRequest.getBadge());
			System.out.println(ticketRequest.getBadgeSmurfit());
			System.out.println(ticketRequest.getIdStore());
			System.out.println(ticketRequest.getIdMaterial());
			System.out.println(ticketRequest.getCarrier());
			System.out.println(ticketRequest.getWeight());
			System.out.println(ticketRequest.getWeigthOk());
			System.out.println(ticketRequest.getOperator());
			System.out.println(ticketRequest.getPuch());
			System.out.println(ticketRequest.getDate());
			System.out.println(ticketRequest.getObservations());
			
			Date dateNow = new Date();
			
			if(ticketRequest.getDate().after(dateNow)) {			
				throw new SolutionException("Error al procesar la fecha del ticket con folio " + ticketRequest.getFolio());
			}
			
			this.ticketService.createdTicket(ticketRequest);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, "Ticket registrado correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	@DeleteMapping("deleted")
	public ResponseEntity<Object> deletedTicket(@RequestParam("idTicket") Integer idTicket) {				
		
		try {
			
			System.out.println(idTicket);
			this.ticketService.deletedTicket(idTicket);
			
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, "Ticket eliminado correctamente");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
	
}
