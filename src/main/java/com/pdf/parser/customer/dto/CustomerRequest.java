package com.pdf.parser.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String companyName;

    @Email
    private String email;

    @NotBlank
    private String password;

}
