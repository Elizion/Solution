package com.ear.core.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.model.TicketInvoiceModel;
import com.ear.core.model.TicketModel;
import com.ear.core.payload.InvoiceExcelRequest;
import com.ear.core.service.InvoiceService;
import com.ear.core.service.TicketService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = "/charge/excel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> readFilePrices(@RequestParam("file") MultipartFile file) throws ParseException {

		String nameFile = file.getOriginalFilename();		
		List<String> listDates = new ArrayList<>();
		
		try {
					
			Workbook workbook = WorkbookFactory.create(file.getInputStream());				
			
			for (int i=0; i< workbook.getNumberOfSheets(); i++) {	
				
				Sheet sheet = workbook.getSheetAt(i);
				
				Row row = null;
				
				int colFolioTicket 		= 0;
				int colCodeStore 		= 1;
				int colLocation 		= 2;
				int colCustomer 		= 3;
				int colMaterial 		= 4;
				int colPlant 			= 5;
				int colAml 				= 6;
				int colDateCollection 	= 7; 
				int colQuantity 		= 8;
				int colPrice 			= 9;
				int colNumberInvoice 	= 10;
				
				String valueFolioTicket 	= null;
				String valueCodeStore 		= null;
				String valueLocation 		= null;
				String valueCustomer 		= null;
				String valueMaterial 		= null;
				String valuePlant 			= null;
				String valueAml 			= null;
				String valueDateCollection 	= null;
				String valueQuantity 		= null;
				String valuePrice 			= null;
				String valueNumberInvoice 	= null;
				
				int cont = 0;
				int section = 1;
								
				DateFormat df = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
				
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					
					row = sheet.getRow(rowIndex);
					
					if (row != null) {
						
						Cell cellFolioTicket = row.getCell(colFolioTicket);
						Cell cellCodeStore = row.getCell(colCodeStore);
						Cell cellLocation = row.getCell(colLocation);
						Cell cellCustomer = row.getCell(colCustomer);
						Cell cellMaterial = row.getCell(colMaterial);
						Cell cellPlant = row.getCell(colPlant);
						Cell cellAml = row.getCell(colAml);
						Cell cellDateCollection = row.getCell(colDateCollection);
						Cell cellQuantity = row.getCell(colQuantity);
						Cell cellPrice = row.getCell(colPrice);
						Cell cellNumberInvoice = row.getCell(colNumberInvoice);
						
						if(!cellFolioTicket.getStringCellValue().equals("CORTE")) {
											
							InvoiceExcelRequest invoiceExcelRequest = new InvoiceExcelRequest();
							
							valueFolioTicket 	= cellFolioTicket.getStringCellValue();
							valueCodeStore 		= cellCodeStore.getStringCellValue();
							valueLocation 		= cellLocation.getStringCellValue();
							valueCustomer 		= cellCustomer.getStringCellValue();
							valueMaterial 		= cellMaterial.getStringCellValue();
							valuePlant 			= cellPlant.getStringCellValue();
							valueAml 			= cellAml.getStringCellValue();
							valueDateCollection = cellDateCollection.getStringCellValue();
							valueQuantity 		= cellQuantity.getStringCellValue();
							valuePrice 			= cellPrice.getStringCellValue();
							valueNumberInvoice 	= cellNumberInvoice.getStringCellValue();
							
							invoiceExcelRequest.setSection(section);
							invoiceExcelRequest.setFolioTicket(valueFolioTicket);
							invoiceExcelRequest.setCodeStore(valueCodeStore);
							invoiceExcelRequest.setLocation(valueLocation);
							invoiceExcelRequest.setCustomer(valueCustomer);
							invoiceExcelRequest.setMaterial(valueMaterial);
							invoiceExcelRequest.setPlant(valuePlant);
							invoiceExcelRequest.setAml(valueAml);							
							
							Date date = df.parse(valueDateCollection);
							
							invoiceExcelRequest.setDateCollection(date);
							double doubleQuantity = Double.parseDouble(valueQuantity);
							invoiceExcelRequest.setQuantity(doubleQuantity);
							double doublePrice = Double.parseDouble(valuePrice);
							invoiceExcelRequest.setPrice(doublePrice);
							invoiceExcelRequest.setNumberInvoice(valueNumberInvoice);
							
							invoiceService.createdInvoiceFromExcel(invoiceExcelRequest);
							
							cont++;
							
							System.out.println("Row " + cont + " section " + section + " insert " + valueFolioTicket + " " + valueCodeStore + " " + valueLocation + " " + valueCustomer + " " + valueMaterial + " " + valuePlant + " " + valueAml + " " + valueDateCollection + " " + valueQuantity + " " + valuePrice + " " + valueNumberInvoice);
							
						} else {
							
							section ++;
							System.out.println("Section " + section);
							
						}
						
					}
					
				}	
				
			}		
						
		} catch (Exception e) {
			
			System.err.println(e);
			return ResponseHandler.generateResponseModel(SolutionConst.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, "Error al procesar el archivo " + nameFile);
			
		}

		return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listDates);
		
	}
		
	@GetMapping("tickets")
	public ResponseEntity<Object> getInvoicesByTikect() {				
		
		try {
						
			List<InvoiceExcelModel> listInvoiceExcelModel = null;
			List<TicketModel> listTicketModel = this.ticketService.getTickets();
			List<TicketInvoiceModel> listTicketInvoiceModel = new ArrayList<TicketInvoiceModel>();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			
			for(TicketModel data: listTicketModel) {
			
				TicketInvoiceModel ticketInvoiceModel = new TicketInvoiceModel();
				
				Integer idTicket = data.getId();
				String folioTicket = this.ticketService.getFolioTicket(idTicket);
				
				if(folioTicket != null) {
									
					listInvoiceExcelModel = this.invoiceService.getFoliosInvoice(folioTicket);
					
					for(InvoiceExcelModel invoice: listInvoiceExcelModel) {
						String dateAsString = sdf.format(invoice.getDateCollection());
						invoice.setDateCollectionAsString(dateAsString);
					}		
					
					ticketInvoiceModel.setTicket(data);
					ticketInvoiceModel.setListInvoiceExcel(listInvoiceExcelModel);
					ticketInvoiceModel.setTotalInvoice(listInvoiceExcelModel.size());
					listTicketInvoiceModel.add(ticketInvoiceModel);
					
				}
				
			}
		
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listTicketInvoiceModel);
			
		} catch (Exception e) {
			
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
	}
	
}
