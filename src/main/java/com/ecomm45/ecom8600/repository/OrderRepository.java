package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
