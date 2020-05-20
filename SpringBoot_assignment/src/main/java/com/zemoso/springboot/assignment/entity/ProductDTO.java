package com.zemoso.springboot.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int id;

    private String productName;

    private String productBrand;

    private double productPrice;

    private int quantity;

    private String productModel;




}
