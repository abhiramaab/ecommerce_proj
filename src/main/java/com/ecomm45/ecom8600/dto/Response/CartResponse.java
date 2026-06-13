package com.ecomm45.ecom8600.dto.Response;

import com.ecomm45.ecom8600.entity.CartItems;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartResponse {

    private Long cartId;
    private List<CartItems> cartItems;
    private Integer totalItems;
    private BigDecimal subTotalPrice;
}
