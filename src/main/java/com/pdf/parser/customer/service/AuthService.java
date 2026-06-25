package com.pdf.parser.customer.service;

import com.pdf.parser.common.exception.AlreadyExistsException;
import com.pdf.parser.common.exception.CustomerNotFoundException;
import com.pdf.parser.common.security.JwtService;
import com.pdf.parser.common.translator.CustomerTranslator;
import com.pdf.parser.customer.dto.CustomerLoginRequest;
import com.pdf.parser.customer.dto.CustomerLoginResponse;
import com.pdf.parser.customer.dto.CustomerRequest;
import com.pdf.parser.customer.dto.CustomerResponse;
import com.pdf.parser.customer.entity.Customer;
import com.pdf.parser.customer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;
    private final CustomerTranslator customerTranslator;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CustomerResponse saveCustomer(CustomerRequest request) {

        Customer customer = customerTranslator.toCustomer(request);

        // Check if customer exists with same email ID
        if(customerRepository.existsByEmail(customer.getEmail())) {
            throw new AlreadyExistsException("Customer already exists with this email ID.");
        }

        // Explicitly set active status true
        customer.setActive(true);
        // Encrypt the password before saving
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerTranslator.toCustomerResponse(customerRepository.save(customer));
    }

    public CustomerLoginResponse loginCustomer(CustomerLoginRequest customerLoginRequest) {
        // Check if customer exist with given data
        Customer existingCustomer = customerRepository.findByEmail(
                customerLoginRequest.getEmail())
                .orElseThrow(
                        () -> new CustomerNotFoundException("Invalid email or password")
                );
        if(!passwordEncoder.matches(customerLoginRequest.getPassword(), existingCustomer.getPassword())) {
            throw new CustomerNotFoundException("Invalid email or password");
        }

        System.out.println("just before token generation");

        //Create JWT token
        String token = jwtService.generateToken(existingCustomer.getEmail());

        System.out.println("just after token: " + token);

        return new CustomerLoginResponse(
                token,
                existingCustomer.getEmail(),
                existingCustomer.getCompanyName()
        );

    }
}
