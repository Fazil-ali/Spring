package com.zemoso.springboot.assignment.service;


import com.zemoso.springboot.assignment.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(int id);

    public void save(Product product);

    public void deleteById(int id);

    public List<Product> findAllByProductName(String productName);



}
