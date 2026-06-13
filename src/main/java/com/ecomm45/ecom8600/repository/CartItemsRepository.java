package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
}
