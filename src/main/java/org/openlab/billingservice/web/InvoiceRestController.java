package org.openlab.billingservice.web;

import org.openlab.billingservice.dto.InvoiceReponseDTO;
import org.openlab.billingservice.dto.InvoiceRequestDTO;
import org.openlab.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping(path="/invoices/{id}")
    public InvoiceReponseDTO getInvoice(@PathVariable(name="id") String invoiceId){
        return invoiceService.getinvoice(invoiceId);
    }
    @GetMapping(path="/invoices/{customerId}")
    public List<InvoiceReponseDTO> getInvoicesByCustomer(@PathVariable String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }
//    @PostMapping(path="/invoices")
//    public <invoiceRequestDTO> InvoiceReponseDTO save(RequestBody InvoiceRequestDTO invoiceRequestDTO){
//        return invoiceService.save(invoiceRequestDTO);
//    }
}
