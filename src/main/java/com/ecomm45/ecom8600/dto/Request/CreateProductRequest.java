package com.ecomm45.ecom8600.dto.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private String productName;
    private String productDescription;
    private Long CategoryId;
    private Integer quantity;
    private BigDecimal price;
}
