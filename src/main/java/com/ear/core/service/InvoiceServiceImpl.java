package com.ear.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.payload.InvoiceExcelRequest;
import com.ear.core.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {


	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public void createdInvoiceFromExcel(InvoiceExcelRequest invoiceExcelRequest) {
		this.invoiceRepository.createdInvoiceFromExcel(invoiceExcelRequest);
	}

	@Override
	public List<InvoiceExcelModel> getFoliosInvoice(String folioTicket) {
		return this.invoiceRepository.getFoliosInvoice(folioTicket);
	}
		
}
