package com.pdf.parser.customer.controller;

import com.pdf.parser.common.response.ApiResponse;
import com.pdf.parser.customer.dto.CustomerRequest;
import com.pdf.parser.customer.dto.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers/")
@RequiredArgsConstructor
public class CustomerController {

    @PostMapping
    public ApiResponse<?>  createCustomer(@Valid @RequestBody CustomerRequest request) {
        return new ApiResponse<CustomerRequest>(true, "Customer created successfully!", request);
    }

}
