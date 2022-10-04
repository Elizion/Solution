package com.ear.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ear.core.model.InvoiceExcelModel;
import com.ear.core.payload.InvoiceExcelRequest;

@Mapper
public interface InvoiceMapper {

	void createdInvoiceFromExcel(@Param("invoiceExcelRequest") InvoiceExcelRequest invoiceExcelRequest);

	List<InvoiceExcelModel> getFoliosInvoice(@Param("folioTicket") String folioTicket);

}
