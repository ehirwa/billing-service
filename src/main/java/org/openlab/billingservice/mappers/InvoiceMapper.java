package org.openlab.billingservice.mappers;

import org.openlab.billingservice.dto.InvoiceReponseDTO;
import org.openlab.billingservice.dto.InvoiceRequestDTO;

import org.openlab.billingservice.entities.Invoice;
import org.mapstruct.Mapper;
@Mapper(componentModel="spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceReponseDTO fromInvoice(Invoice invoice);
}
