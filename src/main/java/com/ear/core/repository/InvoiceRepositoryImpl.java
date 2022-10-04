package com.ear.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ear.core.mapper.InvoiceMapper;
import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.payload.InvoiceExcelRequest;

@Repository
public class InvoiceRepositoryImpl extends GenericRepository implements InvoiceRepository  {

	@Override
	public void createdInvoiceFromExcel(InvoiceExcelRequest invoiceExcelRequest) {
		InvoiceMapper mapper = super.getSqlSession().getMapper( InvoiceMapper.class );
		mapper.createdInvoiceFromExcel(invoiceExcelRequest);
	}

	@Override
	public List<InvoiceExcelModel> getFoliosInvoice(String folioTicket) {
		InvoiceMapper mapper = super.getSqlSession().getMapper( InvoiceMapper.class );
		return mapper.getFoliosInvoice(folioTicket);
	}
	
}
