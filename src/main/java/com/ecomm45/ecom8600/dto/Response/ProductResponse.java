package com.ecomm45.ecom8600.dto.Response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Long productId;
    private String productName;
    private String productDescription;
    private Long categoryId;
    private Integer quantity;
    private BigDecimal price;
}
