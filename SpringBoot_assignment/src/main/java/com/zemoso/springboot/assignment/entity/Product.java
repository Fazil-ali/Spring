package com.zemoso.springboot.assignment.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name="product_name")
    private String productName;

    @Column(name="product_brand")
    private String productBrand;


    @Column(name="product_price")
    private double productPrice;


    @Column(name="quantity")
    private int quantity;

      @Column(name="product_model")
    private String productModel;




}
