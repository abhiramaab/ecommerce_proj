package com.ecomm45.ecom8600.service;

import com.ecomm45.ecom8600.dto.Request.CreateCategoryRequest;
import com.ecomm45.ecom8600.dto.Response.CategoryResponse;

public interface CategoryService {

    CategoryResponse createCategory(CreateCategoryRequest request);
    CategoryResponse findCategoryById(Long categoryId);

}
