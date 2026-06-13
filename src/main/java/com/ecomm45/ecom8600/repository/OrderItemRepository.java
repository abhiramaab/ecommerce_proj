package com.ecomm45.ecom8600.repository;

import com.ecomm45.ecom8600.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
