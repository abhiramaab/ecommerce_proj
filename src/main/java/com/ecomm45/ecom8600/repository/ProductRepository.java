package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
