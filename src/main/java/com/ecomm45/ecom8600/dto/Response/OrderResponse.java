package com.ecomm45.ecom8600.dto.Response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponse {

    private Long orderId;
    private List<String> productNames;
    private BigDecimal totalPrice;
    private List<Long> productIds;

}
