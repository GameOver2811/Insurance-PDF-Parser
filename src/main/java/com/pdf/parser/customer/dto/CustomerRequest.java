package com.pdf.parser.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "Company name is required.")
    private String companyName;

    @Email(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    private String password;

}
