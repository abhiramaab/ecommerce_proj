package com.ecomm45.ecom8600.controller;

import com.ecomm45.ecom8600.dto.Request.CreateProductRequest;
import com.ecomm45.ecom8600.dto.Response.ProductResponse;
import com.ecomm45.ecom8600.service.ProductService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@Data
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return productService.createProduct(createProductRequest);
    }

    @GetMapping("/{productId}")
    public ProductResponse findProductById(@PathVariable Long productId) {
        return productService.findProductById(productId);
    }
}
