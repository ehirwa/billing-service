package org.openlab.billingservice.repositories;

import org.openlab.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository  extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerId(String customerIdId);
}
