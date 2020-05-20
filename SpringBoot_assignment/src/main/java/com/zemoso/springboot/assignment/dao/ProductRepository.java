package com.zemoso.springboot.assignment.dao;

import com.zemoso.springboot.assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    public List<Product> findAllByProductName(String productName);
}
