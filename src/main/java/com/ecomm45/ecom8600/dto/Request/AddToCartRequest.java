package com.ecomm45.ecom8600.dto.Request;

import lombok.Data;

@Data
public class AddToCartRequest {

    private Long productId;
    private Integer quantity;
}
