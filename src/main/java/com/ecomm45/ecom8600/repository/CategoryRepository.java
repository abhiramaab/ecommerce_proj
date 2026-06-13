package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
