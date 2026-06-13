package com.ecomm45.ecom8600.service;

import com.ecomm45.ecom8600.dto.Request.AddToCartRequest;
import com.ecomm45.ecom8600.dto.Response.CartResponse;
import com.ecomm45.ecom8600.entity.Cart;

public interface CartService {

    CartResponse createCart(Long customerId);
    CartResponse getCart(Long customerId);
    CartResponse addToCart(Long customerId, AddToCartRequest request);
    void  removeCartItem(Long customerId, Long cartItemId);
    void  clearCart(Long customerId);
}
