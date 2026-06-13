package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.Cart;
import com.ecomm45.ecom8600.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCustomer(Customer customer);
}
