package com.ecomm45.ecom8600.controller;

import com.ecomm45.ecom8600.dto.Request.CreateCategoryRequest;
import com.ecomm45.ecom8600.dto.Response.CategoryResponse;
import com.ecomm45.ecom8600.service.CategoryService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@Data
public class CatgoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse findCategoryById(@PathVariable Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }
}
