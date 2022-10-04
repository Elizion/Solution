package com.ear.core.repository;

import java.util.List;

import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.payload.InvoiceExcelRequest;

public interface InvoiceRepository {

	void createdInvoiceFromExcel(InvoiceExcelRequest invoiceExcelRequest);

	List<InvoiceExcelModel> getFoliosInvoice(String folioTicket);

}
