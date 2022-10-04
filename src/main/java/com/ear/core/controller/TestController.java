package com.ear.core.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ear.core.config.SolutionConst;
import com.ear.core.model.FileModel;
import com.ear.core.service.TestService;
import com.ear.core.util.ResponseHandler;
import com.ear.core.util.SolutionException;

@RestController
@RequestMapping("api/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	public final static Logger logger = Logger.getLogger(TestController.class);
	public final static String EXTENSION = ".xlsx";
	public final static String NAME_FILE = "dummy";
	
	@RequestMapping("/signout")
	public ResponseEntity<Object> signout() throws SolutionException {						
		
		try {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			auth.getCredentials();
			System.out.println(auth.getAuthorities().size());
			return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.OK, auth.getCredentials());
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
            return ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

	}
	
	@RequestMapping(value = "/write/file", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> writeFile(
			@RequestParam(name = "strDateInit") String strDateInit,
			@RequestParam(name = "strDateEnd") String strDateEnd,
			@RequestParam(name = "idTimezone") String idTimezone) {

		try {

			ArrayList<String> listDates = this.testService.createListDates(null, null, null, null);
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("daterange");
			
			int rowCount = 0;
			
			for(int c = 0; c < listDates.size(); ++c) {
				
				XSSFRow row = sheet.createRow(++rowCount);
				XSSFCell cell = row.createCell(0);				
				cell.setCellValue(listDates.get(c));
								
			}			

			try (FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\files\\workbook.xlsx")) {
				workbook.write(outputStream);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/read/file", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> readFile(@RequestParam("file") MultipartFile file) {

		try {

			ArrayList<String> arrData = new ArrayList<String>();
			this.createFileTxt(arrData, "test");

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	private void createFileTxt(ArrayList<String> arrData, String process) throws IOException {
		FileWriter writer = new FileWriter("C:\\Users\\elial\\OneDrive\\Escritorio\\out\\" + process + ".txt");
		int size = arrData.size();
		for (int i = 0; i < size; i++) {
			String str = arrData.get(i).toString();
			writer.write(str);
			if (i < size - 1)
				writer.write("\n");
		}
		writer.close();
	}
	
	@RequestMapping(value = "/generate/excel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createExcel(
			@RequestParam("dateInit") String dateInit, 
			@RequestParam("dateEnd") String dateEnd, 
			@RequestParam("timezone") String timezone, 
			@RequestParam("periodicity") String periodicity) throws IOException {
		   
		FileModel fileModel = new FileModel();
	    ByteArrayOutputStream ous = null;
	    InputStream ios = null;
	    
	    try {
	    	
			XSSFWorkbook xssfworkbook = new XSSFWorkbook();
			SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(xssfworkbook, -1, Boolean.TRUE);			
			Sheet sheet = sxssfWorkbook.createSheet("FECHAS");
			logger.debug(sheet.getSheetName());
			
			ArrayList<String> listDates = this.testService.createListDates(dateInit, dateEnd, timezone, periodicity);
			
			for(int c = 1; c < listDates.size(); c++) {			
				
				Row rowData = sheet.getRow(c);	
			
				if (rowData == null) rowData = sheet.createRow(c);													
				Cell cell = rowData.createCell(0);
				cell.setCellValue(listDates.get(c));							
				
			}									
			
			String path = "src\\main\\resources\\files\\"+NAME_FILE+EXTENSION;					
			FileOutputStream outputStream = new FileOutputStream(path);
			sxssfWorkbook.setCompressTempFiles(true);
			sxssfWorkbook.write(outputStream);					
			File file = new File(path);		    
	        byte[] buffer = new byte[4096];
	        ous = new ByteArrayOutputStream();
	        ios = new FileInputStream(file);
	        int read = 0;	       
	        while ((read = ios.read(buffer)) != -1) {
	            ous.write(buffer, 0, read);
	        }	        
	        byte[] bytes = ous.toByteArray();	        
	        String encodedString = Base64.getEncoder().encodeToString(bytes);	        	     
	        
	        fileModel.setExtension(EXTENSION);
	        fileModel.setNameFile(NAME_FILE);
	        fileModel.setEncodeB64(encodedString);
	        fileModel.setSize(file.length());      
	        fileModel.setPath(path);
	        
	        return ResponseHandler.generateResponseModel(SolutionConst.SUCCESS, HttpStatus.CREATED, fileModel);
		    
	    } finally {	    	
	        try {	        	
	            if (ous != null)
	                ous.close();	            
	        } catch (IOException e) {	        
	    		logger.error(e);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
	        }
	        try {	        	
	            if (ios != null)
	                ios.close();	            
	        } catch (IOException e) {	        	
	    		logger.error(e);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);				
	        }	        
	    }

	}
	/*
	
			System.out.println(file.getOriginalFilename());
			
			List<PriceMaterialModel> listPrice = new ArrayList<>();
		    InputStream inputStream = file.getInputStream();
		 
		    Workbook workbook = new XSSFWorkbook(inputStream);
		    Sheet firstSheet = workbook.getSheetAt(0);
		    
		    System.out.println(firstSheet.getSheetName());

		    Iterator<Row> iterator = firstSheet.iterator();
		    
		    while (iterator.hasNext()) {
		    	
		        Row nextRow = iterator.next();
		        
		        Iterator<Cell> cellIterator = nextRow.cellIterator();
		        PriceMaterialModel price = new PriceMaterialModel();
		 
		        while (cellIterator.hasNext()) {		        	
		            Cell nextCell = cellIterator.next();
		            int columnIndex = nextCell.getColumnIndex();		            
		            switch (columnIndex) {
		            case 2:
		            	price.setNameMaterial((String) getCellValue(nextCell));
		                break;		                
		            case 4:
		            	price.setNameStore((String) getCellValue(nextCell));
		                break;		            
		            case 3:
		            	price.setChain((String) getCellValue(nextCell));
		                break;		            
		            case 5:
		            	price.setCodeStatus((String) getCellValue(nextCell));
		                break;
		            case 6:
		            	price.setInitCollection((String) getCellValue(nextCell));
		                break;		                
		            case 7:
		            	price.setEndCollection((String) getCellValue(nextCell));
		                break;		             	            	
		            case 8:
	            		price.setPrice((double) getCellValue(nextCell));
	            		break;	            			 					            		           		            		            		            		            
		            }		            
		        }		        
		        listPrice.add(price);		        
		    }	
	        
			Calendar calTo = this.getDateToDay();
			Calendar calFrom = this.getDateFromDay();
			
			System.out.println("Fecha desde " + calFrom.getTime());
			System.out.println("Fecha hasta " + calTo.getTime());			

			Integer idStore = null;
			String nameStore = null;
			Integer idMaterial = null;
			String nameMaterial = null;
			Integer idUnit = null;
			Double price = null;
			String chain = null;
			String initCollection = null;
			String endCollection = null;
			String codeStatus = null;
			
			for (Date dateI = calFrom.getTime(); calFrom.before(calTo); calFrom.add(Calendar.DATE, 1), dateI = calFrom.getTime()) {
				
				System.out.println("EL proceso inica con fechar" + dateI);

				int index = 1;

			    for(PriceMaterialModel data:listPrice) {
			    	
			    	nameStore = data.getNameStore();
			    	nameMaterial = data.getNameMaterial();
			    			
			    	idStore = this.storeService.getIdStore(nameStore);
			    	idMaterial = this.materialService.getIdMaterial(nameMaterial);
			    	idUnit = 1;
			    	
			    	chain = data.getChain();
			    	
			    	if(data.getCodeStatus().equals("CANCELADA")) {
			    		codeStatus = "SYS000";
			    	} else {
			    		codeStatus = "SYS001";
			    	}
			    	
			    	initCollection = data.getInitCollection();
			    	endCollection = data.getEndCollection();			    
			    	price = data.getPrice();
			    	
			    	System.out.println(index + " " + dateI + " " + nameStore + " " + chain + " " + codeStatus + " " + initCollection + " " + endCollection + " " + price);			    	
			    	this.priceService.insertPrice(dateI, idStore, idMaterial, idUnit, chain, codeStatus, initCollection, endCollection, price);
			    	System.out.println("Insert Into..." + index);
			    	index++;
			    	
			    }
			    
			}
			
	*/
}
