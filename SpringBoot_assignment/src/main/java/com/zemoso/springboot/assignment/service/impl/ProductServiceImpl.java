package com.zemoso.springboot.assignment.service.impl;

import com.zemoso.springboot.assignment.dao.ProductRepository;
import com.zemoso.springboot.assignment.entity.Product;
import com.zemoso.springboot.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){

        this.productRepository=productRepository;
    }


    @Override
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    @Transactional
    public Product findById(int id) {

        Optional<Product> result=productRepository.findById(id);

        Product product=null;

        if(result.isPresent()){

            product=result.get();
        }

        return product;
    }


    @Override
    @Transactional
    public void save(Product product) {

        productRepository.save(product);
    }


    @Override
    @Transactional
    public void deleteById(int id) {

        productRepository.deleteById(id);

    }


    @Override
    @Transactional
    public List<Product> findAllByProductName(String productName) {
        return productRepository.findAllByProductName(productName);
    }

}
