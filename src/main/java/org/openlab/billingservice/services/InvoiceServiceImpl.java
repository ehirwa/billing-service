package org.openlab.billingservice.services;

import org.openlab.billingservice.dto.InvoiceReponseDTO;
import org.openlab.billingservice.dto.InvoiceRequestDTO;
import org.openlab.billingservice.entities.Customer;
import org.openlab.billingservice.entities.Invoice;
import org.openlab.billingservice.mappers.InvoiceMapper;
import org.openlab.billingservice.openfeign.CustomerRestClient;
import org.openlab.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceReponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        Invoice saveInvoice=invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceReponseDTO getinvoice(String invoiceId) {
        Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceReponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices=invoiceRepository.findByCustomerId(customerId);
        return invoices.
                stream()
                .map(invoice->invoiceMapper.fromInvoice(invoice))
        .collect(Collectors.toList());

    }
}
