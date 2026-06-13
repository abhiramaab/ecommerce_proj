package com.ecomm45.ecom8600.serviceImpl;

import com.ecomm45.ecom8600.dto.Request.CreateProductRequest;
import com.ecomm45.ecom8600.dto.Response.ProductResponse;
import com.ecomm45.ecom8600.entity.Customer;
import com.ecomm45.ecom8600.entity.Product;
import com.ecomm45.ecom8600.entity.Users;
import com.ecomm45.ecom8600.repository.CustomerRepository;
import com.ecomm45.ecom8600.repository.ProductRepository;
import com.ecomm45.ecom8600.repository.UsersRepository;
import com.ecomm45.ecom8600.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {

        Product  product = new Product();

        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategoryId(request.getCategoryId());


        Product savedProduct = productRepository.save(product);
        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductId(savedProduct.getId());
        productResponse.setProductName(savedProduct.getProductName());
        productResponse.setProductDescription(savedProduct.getProductDescription());
        productResponse.setPrice(savedProduct.getPrice());
        productResponse.setQuantity(savedProduct.getQuantity());
        productResponse.setCategoryId(savedProduct.getCategoryId());
        return productResponse;

    }

    @Override
    public ProductResponse findProductById(Long categoryId) {

        Product product = productRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Product not found"));
        if (!product.getId().equals(categoryId)) {
            throw new RuntimeException("Category not found");
        }
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setProductDescription(product.getProductDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setCategoryId(product.getCategoryId());
        return productResponse;
    }
}
