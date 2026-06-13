package com.ecomm45.ecom8600.controller;

import com.ecomm45.ecom8600.dto.Request.CreateOrderRequest;
import com.ecomm45.ecom8600.dto.Response.OrderResponse;
import com.ecomm45.ecom8600.service.OrderService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Data
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{email}")
    public OrderResponse createOrder(@PathVariable String email, @RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(email, createOrderRequest);
    }

    @GetMapping("/{customerId}/{orderId}")
    public OrderResponse findById(@PathVariable Long customerId,@PathVariable Long orderId) {
        return orderService.findById(customerId, orderId);
    }
}
