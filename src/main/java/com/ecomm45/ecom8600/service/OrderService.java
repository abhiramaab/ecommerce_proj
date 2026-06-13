package com.ecomm45.ecom8600.service;

import com.ecomm45.ecom8600.dto.Request.CreateOrderRequest;
import com.ecomm45.ecom8600.dto.Response.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(String email, CreateOrderRequest request);
    OrderResponse findById(Long customerId, Long OrderId);
}
