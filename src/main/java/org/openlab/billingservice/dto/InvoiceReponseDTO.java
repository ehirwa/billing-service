package org.openlab.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openlab.billingservice.entities.Customer;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceReponseDTO {

    private String id;
    private Date date;
    private BigDecimal amount;
    private String clientID;
   // @Transient
    private Customer customer;
}
