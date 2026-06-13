package com.ecomm45.ecom8600.controller;

import com.ecomm45.ecom8600.dto.Request.AddToCartRequest;
import com.ecomm45.ecom8600.dto.Request.CreateOrderRequest;
import com.ecomm45.ecom8600.dto.Response.CartResponse;
import com.ecomm45.ecom8600.service.CartService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Data
public class CartController {

    private final CartService cartService;

    @PostMapping("/{customerId}")
    public CartResponse createOrder(@PathVariable Long customerId) {
        return cartService.createCart(customerId);
    }

    @GetMapping("/{customerId}")
    public CartResponse getCart(@PathVariable Long customerId) {
        return cartService.getCart(customerId);
    }


    @PostMapping("/{customerId}/items")
    public CartResponse addToCart(
            @PathVariable Long customerId,
            @RequestBody AddToCartRequest request) {

        return cartService.addToCart(customerId, request);
    }

    @DeleteMapping("/{customerId}/items/{cartItemId}")
    public void removeCartItem(
            @PathVariable Long customerId,
            @PathVariable Long cartItemId) {

        cartService.removeCartItem(customerId, cartItemId);
    }

    @DeleteMapping("/{customerId}/clear")
    public void clearCart(@PathVariable Long customerId) {

        cartService.clearCart(customerId);
    }

}
