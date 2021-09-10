package org.openlab.billingservice.services;

import org.openlab.billingservice.dto.InvoiceReponseDTO;
import org.openlab.billingservice.dto.InvoiceRequestDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceReponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceReponseDTO getinvoice(String invoiceId);

    List<InvoiceReponseDTO> invoicesByCustomerId(String customerId);


}