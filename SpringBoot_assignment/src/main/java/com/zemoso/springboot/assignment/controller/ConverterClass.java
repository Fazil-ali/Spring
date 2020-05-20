package com.zemoso.springboot.assignment.controller;

import com.zemoso.springboot.assignment.entity.Product;
import com.zemoso.springboot.assignment.entity.ProductDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ConverterClass {


        ModelMapper modelMapper=new ModelMapper();

        public ProductDTO convertToDTO(Product product) {

            return modelMapper.map(product, ProductDTO.class);
        }

        public Product convertToEntity(ProductDTO productDTO) {

               return modelMapper.map(productDTO, Product.class);
        }

}
