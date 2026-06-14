package com.pdf.parser.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private Long id;

    private String companyName;

    private String email;

    private Boolean active;

}
