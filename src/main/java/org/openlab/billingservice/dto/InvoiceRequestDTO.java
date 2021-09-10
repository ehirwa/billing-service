package org.openlab.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openlab.billingservice.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceRequestDTO extends InvoiceReponseDTO {
    private BigDecimal amount;
    private String clientID;

}
