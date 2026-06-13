package com.ecomm45.ecom8600.entity;

import com.ecomm45.ecom8600.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private Status orderStatus;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JsonBackReference
    private Product product;
}
