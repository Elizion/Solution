package com.ear.core.service;

import java.util.List;

import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.payload.InvoiceExcelRequest;

public interface InvoiceService {

	void createdInvoiceFromExcel(InvoiceExcelRequest invoiceExcelRequest);

	List<InvoiceExcelModel> getFoliosInvoice(String folioTicket);	
	
}
