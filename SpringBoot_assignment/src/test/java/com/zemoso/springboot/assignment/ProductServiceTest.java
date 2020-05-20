package com.zemoso.springboot.assignment;


import com.zemoso.springboot.assignment.dao.ProductRepository;
import com.zemoso.springboot.assignment.entity.Product;
import com.zemoso.springboot.assignment.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;


    private List<Product> list=new ArrayList<Product>();

    @Test
    public void findAllTest(){

        Product p1=new Product(1,"TV","LG",30000,10,"M2020");
        Product p2=new Product(2,"Cooler","Bajaj",10000,15,"M2020");
        Product p3=new Product(3,"Oven","Samsung",10000,19,"M2020");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        Mockito.when(productRepository.findAll()).thenReturn(list);

        List<Product> productList=productRepository.findAll();

        assertEquals(3,productList.size());

    }

    @Test
    public void findByIdTest(){

        Product product=new Product(4,"Oven","Samsung",10000,19,"M2020");

        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        assertEquals(product,productService.findById(product.getId()));
    }

    @Test
    public void saveTest(){

        Product product=new Product(5,"Refrigerator","Godrej",55000,10,"M2019");


        productService.save(product);

        Mockito.verify(productRepository,Mockito.times(1)).save(product);


    }

    @Test
    public void deleteByIdTest(){

        Product product=new Product(6,"laptop","Dell",50000,10,"MR2018");

        productService.deleteById(product.getId());

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(product.getId());

    }

    @Test
    public void findAllByProductNameTest(){

        Product p1=new Product(1,"TV","LG",30000,10,"MR2017");
        Product p2=new Product(2,"TV","MI",15000,5,"MD2019");

        list.add(p1);
        list.add(p2);

        Mockito.when(productRepository.findAllByProductName("TV")).thenReturn(list);

        List<Product> productList=productService.findAllByProductName("TV");

        assertEquals(2,productList.size());


    }

}
