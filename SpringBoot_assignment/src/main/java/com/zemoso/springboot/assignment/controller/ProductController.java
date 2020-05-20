package com.zemoso.springboot.assignment.controller;

import com.zemoso.springboot.assignment.entity.Product;
import com.zemoso.springboot.assignment.entity.ProductDTO;
import com.zemoso.springboot.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){

        this.productService=productService;
    }

    @Autowired
    private ConverterClass converter;


    @GetMapping("/list")
    public String listProducts(Model model){

        List<Product> productList=productService.findAll();

        List<ProductDTO> productDTOList=new ArrayList<>();

        for( Product product:productList){

            productDTOList.add(converter.convertToDTO(product));
        }

        model.addAttribute("products",productDTOList);

        return "list-products";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddProduct(Model model){

        ProductDTO productDTO=new ProductDTO();

        model.addAttribute("product",productDTO);

        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO){

        Product product=converter.convertToEntity(productDTO);

        productService.save(product);

        return "redirect:/products/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdateProduct(@RequestParam("productId") int productId, Model model) {


            Product product = productService.findById(productId);

            if(product==null) {
                model.addAttribute("productId", productId);
                return "error-page";
            }

            model.addAttribute("product", product);

            return "product-form";

    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int productId){

        productService.deleteById(productId);

        return "redirect:/products/list";
    }


    @GetMapping("/name")
    public String findByProductName( @RequestParam("productName") String productName, Model model){


        List<Product> productList= productService.findAllByProductName(productName);

        List<ProductDTO> productDTOList=new ArrayList<>();

        for( Product product:productList){

            productDTOList.add(converter.convertToDTO(product));
        }


        model.addAttribute("products",productDTOList);

        return "list-products";
    }



    @GetMapping("/home")
    public String showHomePage(Model model){

        List<Product> productList=productService.findAll();

        List<ProductDTO> productDTOList=new ArrayList<>();

        for( Product product:productList){

            productDTOList.add(converter.convertToDTO(product));
        }

        model.addAttribute("products",productDTOList);

        return "home";


    }

    @GetMapping("/name/user")
    public String findByProductNameForUser( @RequestParam("productName") String productName, Model model){


        List<Product> productList= productService.findAllByProductName(productName);

        List<ProductDTO> productDTOList=new ArrayList<>();

        for( Product product:productList){

            productDTOList.add(converter.convertToDTO(product));
        }


        model.addAttribute("products",productDTOList);

        return "home";
    }


}
