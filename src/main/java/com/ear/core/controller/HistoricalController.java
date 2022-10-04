package com.ear.core.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ear.core.config.SolutionConst;
import com.ear.core.exception.SolutionException;
import com.ear.core.model.PriceMaterialModel;
import com.ear.core.model.StoreModel;
import com.ear.core.service.ChainService;
import com.ear.core.service.MaterialService;
import com.ear.core.service.PriceService;
import com.ear.core.service.StoreService;
import com.ear.core.util.ResponseHandler;

@RestController
@RequestMapping("api/historical")
public class HistoricalController {

	@Autowired
	private PriceService priceService;
	
	@Autowired
	private ChainService chainService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private MaterialService materialService;
	
	private Calendar getDateFromDay(int day, int month, int year) {
		month = month -1;
		Calendar calFrom = Calendar.getInstance();
		calFrom.set(Calendar.YEAR, year);
		calFrom.set(Calendar.MONTH, month);
		calFrom.set(Calendar.DAY_OF_MONTH, day);
		calFrom.set(Calendar.HOUR_OF_DAY, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);
		calFrom.set(Calendar.MILLISECOND, 0);		
		return calFrom;
	}
	
	private Calendar getDateToDay(int day, int month, int year) {
		month = month -1;
		Calendar calFrom = Calendar.getInstance();
		calFrom.set(Calendar.YEAR, year);
		calFrom.set(Calendar.MONTH, month);
		calFrom.set(Calendar.DAY_OF_MONTH, day);
		calFrom.set(Calendar.HOUR_OF_DAY, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);
		calFrom.set(Calendar.MILLISECOND, 0);		
		return calFrom;
	}	
	
	@RequestMapping(value = "/charge/prices", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> readFilePrices(@RequestParam("file") MultipartFile file) throws ParseException {

		String nameFile = file.getOriginalFilename();		
		List<String> listDates = new ArrayList<>();
		String nameSheet = null;
		
		try {
					
			Workbook workbook = WorkbookFactory.create(file.getInputStream());				
			
			for (int i=0; i< workbook.getNumberOfSheets(); i++) {	
				
				Sheet sheet = workbook.getSheetAt(i);
				System.out.println(sheet.getSheetName());
				nameSheet = sheet.getSheetName();
				
				Row row = null;
				
				int colCode 	   = 0;
				int colMaterial    = 1;
				int colChain 	   = 2;
				int colStoreType   = 3;
				int colStore 	   = 4;
				int colStatus 	   = 5;
				int colDateInit    = 6;
				int colDateEnd 	   = 7;
				int colPrice 	   = 8;
				
				String valueCode 	    = null;
				Integer code 		    = null;
				String valueMaterial 	= null;
				Integer idMaterial 	 	= null;
				Integer idChain 	 	= null;
				Integer idStoreType  	= null;
				String valueChain 	 	= null;
				String valueStore 	 	= null;
				Integer idStore 	 	= null;
				String valueStatus 	 	= null;
				String valueDateInit 	= null;
				String valueDateEnd  	= null;
				String valueStoreType	= null;
				Date dateInit 		 	= null;
				Date dateEnd 		 	= null;						
				String valuePrice 	 	= null;
				Double price 		 	= null;
				
				//int countRow = 2;
				
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				List<PriceMaterialModel> listPriceMaterial = new ArrayList<>();
				
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					
					PriceMaterialModel priceMaterial = new PriceMaterialModel();
					
					row = sheet.getRow(rowIndex);
					
					if (row != null) {
						
						Cell cellCode = row.getCell(colCode);
						Cell cellMaterial = row.getCell(colMaterial);
						Cell cellChain = row.getCell(colChain);
						Cell cellStoreType = row.getCell(colStoreType);
						Cell cellStore = row.getCell(colStore);
						Cell cellStatus = row.getCell(colStatus);
						Cell cellDateInit = row.getCell(colDateInit);										
						Cell cellDateEnd = row.getCell(colDateEnd);
						Cell cellPrice = row.getCell(colPrice);
						
						if(cellDateEnd == null) {
							row.createCell(colDateEnd).setCellValue("null");
							cellDateEnd = row.getCell(colDateEnd);
						}
						
						if (cellCode != null || cellMaterial != null || cellStore != null || cellStatus != null || cellDateInit != null || cellPrice != null) {
							
							valueCode = cellCode.getStringCellValue();														
							code = Integer.parseInt(valueCode.trim());										
							valueMaterial = cellMaterial.getStringCellValue();
							valueStore = cellStore.getStringCellValue();
							valueChain = cellChain.getStringCellValue();
							valueStoreType = cellStoreType.getStringCellValue();
							valueStatus = cellStatus.getStringCellValue();						
							valueDateInit = cellDateInit.getStringCellValue();
							dateInit = format.parse(valueDateInit);
							valueDateEnd = cellDateEnd.getStringCellValue();
							valuePrice = cellPrice.getStringCellValue();						
							price = Double.parseDouble(valuePrice);
							
							if(!valueDateEnd.equals("null")) {
								dateEnd = format.parse(valueDateEnd);							
							} else {
								valueDateEnd = null;
								dateEnd = null;
							}
							
							StoreModel storeModel = this.storeService.getStoreByCode(code);
													
							if(storeModel == null) {
								System.err.println("No se encontro la tienda, revise la configuración...");
								throw new SolutionException("nullPointerException");
							}
							
							idMaterial  = this.materialService.getIdMaterial(valueMaterial.trim());
							idStore 	= this.storeService.getIdStore(valueStore.trim(), storeModel.getCode());
							idStoreType = this.storeService.getIdStoreType(valueStoreType.trim());
							idChain 	= this.chainService.getIdChain(valueChain.trim());
													
							if(valueStatus.equals("CANCELADA")) {
								valueStatus = "SYS000";
							}
							
							if(valueStatus.equals("VIGENTE")) {
								valueStatus = "SYS001";
							}
							
							priceMaterial.setIdUnit(1);
							priceMaterial.setCode(code);
							priceMaterial.setIdMaterial(idMaterial);
							priceMaterial.setIdStore(idStore);
							priceMaterial.setIdChain(idChain);
							priceMaterial.setIdStoreType(idStoreType);
							priceMaterial.setCodeStatus(valueStatus);
							priceMaterial.setInitCollection(dateInit);
							priceMaterial.setEndCollection(dateEnd);
							priceMaterial.setPrice(price);
							
							listPriceMaterial.add(priceMaterial);
							
							if(idMaterial == null) {
								System.err.println("No se encontro el material, revise la configuración...");
								throw new SolutionException("nullPointerException");	
							}
							if(idChain == null) {
								System.err.println("No se encontro la cadena, revise la configuración...");
								throw new SolutionException("nullPointerException");	
							}
							if(idStore == null) {
								System.err.println("No se encontro la tienda, revise la configuración...");
								throw new SolutionException("nullPointerException");	
							}
							if(idStoreType == null) {
								System.err.println("No se encontro el tipo de tienda, revise la configuración...");
								throw new SolutionException("nullPointerException");
							}
							
							//System.out.println(countRow + "[" + dateInit + "] [" + dateEnd +  "]");
							//System.out.println(countRow + " " + code + " [" + valueStatus + "] [" + dateInit + "] [" + dateEnd +  "] [" + idMaterial + "]" + valueMaterial + " [" + idChain + "]" + valueChain + " [" + idStore + " " +  valueStore + "] [" + price + "]");
													
				    	} else {
				    		
				    		System.err.println("No se encontro la celda, revise el archivo...");
				    		throw new SolutionException("nullPointerException");
				    		
				    	}
						
					} else {
						
						System.err.println("No se encontro fila...");
						throw new SolutionException("nullPointerException");
						
					}
					
					//countRow ++;
					
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				String[] dates = nameSheet.split("_");
				String dateInitStr = dates[0];
				String dateEndStr = dates[1];
				dateEndStr = dateEndStr.substring(0,10);
				
				String[] dateInitParts = dateInitStr.split("-");
				String[] dateEndParts = dateEndStr.split("-");
				
				String dayInit = dateInitParts[0];
				String monthInit = dateInitParts[1];
				String yearInit = dateInitParts[2];
				
				String dayEnd = dateEndParts[0];
				String monthEnd = dateEndParts[1];
				String yearEnd = dateEndParts[2];
							
				Integer dayInitRet = Integer.parseInt(dayInit);
				Integer monthInitRet = Integer.parseInt(monthInit);
				Integer yearInitRet = Integer.parseInt(yearInit);
				
				Integer dayEndRet = Integer.parseInt(dayEnd);
				Integer monthEndRet = Integer.parseInt(monthEnd);
				Integer yearEndRet = Integer.parseInt(yearEnd);

				Calendar calendarFrom = this.getDateFromDay(dayInitRet, monthInitRet, yearInitRet);
				Calendar calendarTo = this.getDateToDay(dayEndRet, monthEndRet, yearEndRet);
					
				String stringDate = null;
				
				for (Date dateProcess = calendarFrom.getTime(); calendarFrom.before(calendarTo); calendarFrom.add(Calendar.DATE, 1), dateProcess = calendarFrom.getTime()) {
					
					stringDate = sdf.format(dateProcess);				
					listDates.add(stringDate);
					System.out.println("Procesa fecha " + stringDate);

					int index = 1;

				    for(PriceMaterialModel data: listPriceMaterial) {
				    	
				    	data.setDate(dateProcess);
				    	this.priceService.insertPrice(data);
				    	System.out.println(index + " insert price " + data.getDate());
				    	index++;
				    	
				    }
				    
				}
				
				
			}		
						
		} catch (Exception e) {
			
			System.err.println(e);
			return ResponseHandler.generateResponseModel(SolutionConst.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, "Error al procesar el archivo " + nameFile);
			
		}

		return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, listDates);
		
	}
	
}
