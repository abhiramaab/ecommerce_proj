package com.ecomm45.ecom8600.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private BigDecimal itemPrice;
    private Integer quantity;
    private BigDecimal subTotal;
    private Integer totalItems;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product product;
}
