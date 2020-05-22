package com.zemoso.springboot.assignment.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name="product_name")
    private String productName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name="product_brand")
    private String productBrand;

    @NotNull(message = "is required")
    @Min(value=1000,message="Minimun should be 1000")
    @Column(name="product_price")
    private double productPrice;


    @NotNull(message = "is required")
    @Min(value=1,message="Minimun should be 1")
    @Column(name="quantity")
    private int quantity;

    @NotNull(message = "is required")
    @Pattern(regexp="^[A-Z0-9\\-]{7}", message="should have Uppercase characters and numbers")
    @Column(name="product_model")
    private String productModel;




}
