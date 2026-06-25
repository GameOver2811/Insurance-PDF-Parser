package com.pdf.parser.customer.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginResponse {

    private String token;

    private String email;

    private String companyName;

}
