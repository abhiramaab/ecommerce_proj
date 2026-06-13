package com.ecomm45.ecom8600.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {

    private Long cartItemId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
    private BigDecimal subTotal;
    private Integer totalItems;
}
