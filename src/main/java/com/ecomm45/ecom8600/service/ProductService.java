package com.ecomm45.ecom8600.service;

import com.ecomm45.ecom8600.dto.Request.CreateProductRequest;
import com.ecomm45.ecom8600.dto.Response.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest request);
    ProductResponse findProductById(Long categoryId);
}
