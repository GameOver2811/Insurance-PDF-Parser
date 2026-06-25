package com.pdf.parser.customer.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private Long id;

    private String companyName;

    private String email;

    private Boolean active;

}
