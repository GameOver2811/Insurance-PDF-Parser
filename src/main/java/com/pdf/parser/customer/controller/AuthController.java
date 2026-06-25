package com.pdf.parser.customer.controller;

import com.pdf.parser.common.response.ApiResponse;
import com.pdf.parser.customer.dto.CustomerLoginRequest;
import com.pdf.parser.customer.dto.CustomerLoginResponse;
import com.pdf.parser.customer.dto.CustomerRequest;
import com.pdf.parser.customer.dto.CustomerResponse;
import com.pdf.parser.customer.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/customers/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("signup/")
    public ResponseEntity<ApiResponse<?>> createCustomer(@Valid @RequestBody CustomerRequest request) {
        CustomerResponse customer = authService.saveCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Customer created successfully!",
                        customer
                ));
    }

    @PostMapping("login/")
    public ResponseEntity<ApiResponse<?>> loginCustomer(@Valid @RequestBody CustomerLoginRequest customerLoginRequest) {
        System.out.println("its working till here");
        CustomerLoginResponse customerLoginResponse = authService.loginCustomer(customerLoginRequest);
        System.out.println("It executed sucessfully");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ApiResponse<>(
                        true,
                        "Login successful!",
                        customerLoginResponse
                ));
    }

}
