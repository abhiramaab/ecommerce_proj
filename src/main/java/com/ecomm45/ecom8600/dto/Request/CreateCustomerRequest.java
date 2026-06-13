package com.ecomm45.ecom8600.dto.Request;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;
}
