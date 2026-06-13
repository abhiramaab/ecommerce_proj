package com.ecomm45.ecom8600.dto.Response;

import com.ecomm45.ecom8600.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;
    List<Long> orderIds;
}
