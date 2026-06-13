package com.ecomm45.ecom8600.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Cart> carts;
}
