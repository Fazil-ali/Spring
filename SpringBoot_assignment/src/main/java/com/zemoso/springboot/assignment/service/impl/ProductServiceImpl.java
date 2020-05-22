package com.zemoso.springboot.assignment.service.impl;

import com.zemoso.springboot.assignment.dao.ProductRepository;
import com.zemoso.springboot.assignment.entity.Product;
import com.zemoso.springboot.assignment.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService {


    private ProductRepository productRepository;

    private Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);



    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){

        this.productRepository=productRepository;
    }


    @Override

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    public Product findById(int id) {

        Optional<Product> result=productRepository.findById(id);

        Product product=null;

        if(result.isPresent()){

            product=result.get();
        }

        return product;
    }


    @Override
    public void save(Product product) {

        logger.info(">>>>>>>> "+product.toString());
        productRepository.save(product);
    }


    @Override
    public void deleteById(int id) {

        productRepository.deleteById(id);

    }


    @Override
    public List<Product> findAllByProductName(String productName) {
        return productRepository.findAllByProductName(productName);
    }



}
