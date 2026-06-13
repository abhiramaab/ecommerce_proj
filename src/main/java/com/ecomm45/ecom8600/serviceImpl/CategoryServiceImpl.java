package com.ecomm45.ecom8600.serviceImpl;

import com.ecomm45.ecom8600.dto.Request.CreateCategoryRequest;
import com.ecomm45.ecom8600.dto.Response.CategoryResponse;
import com.ecomm45.ecom8600.entity.Category;
import com.ecomm45.ecom8600.entity.Customer;
import com.ecomm45.ecom8600.entity.Users;
import com.ecomm45.ecom8600.repository.CategoryRepository;
import com.ecomm45.ecom8600.repository.CustomerRepository;
import com.ecomm45.ecom8600.repository.UsersRepository;
import com.ecomm45.ecom8600.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UsersRepository usersRepository;
    private final CustomerRepository customerRepository;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {


        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());

        Category savedCategory = categoryRepository.save(category);

        CategoryResponse response = new CategoryResponse();

        response.setCategoryId(savedCategory.getId());
        response.setCategoryName(savedCategory.getCategoryName());
        response.setCategoryDescription(savedCategory.getCategoryDescription());
        return response;


    }

    @Override
    public CategoryResponse findCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        if (!category.getId().equals(categoryId)) {
            throw new RuntimeException("Category Id does not match");
        }
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryName(category.getCategoryName());
        categoryResponse.setCategoryDescription(category.getCategoryDescription());
        categoryResponse.setCategoryId(category.getId());
        return categoryResponse;
    }
}
