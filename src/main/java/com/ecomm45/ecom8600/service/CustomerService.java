package com.ecomm45.ecom8600.service;

import com.ecomm45.ecom8600.dto.Request.CreateCustomerRequest;
import com.ecomm45.ecom8600.dto.Response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);
    CustomerResponse findCustomerById(Long id);
    List<CustomerResponse> findAllCustomers();
}
