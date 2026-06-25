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
public class CustomerLoginRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

}
