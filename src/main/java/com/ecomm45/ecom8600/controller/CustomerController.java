package com.ecomm45.ecom8600.controller;

import com.ecomm45.ecom8600.dto.Request.CreateCustomerRequest;
import com.ecomm45.ecom8600.dto.Response.CustomerResponse;
import com.ecomm45.ecom8600.service.CustomerService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Data
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);

    }

    @GetMapping("/{customerId}")
    public CustomerResponse findCustomerById(@PathVariable Long customerId) {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping
    public List<CustomerResponse> findAllCustomers() {
        return customerService.findAllCustomers();
    }
}
