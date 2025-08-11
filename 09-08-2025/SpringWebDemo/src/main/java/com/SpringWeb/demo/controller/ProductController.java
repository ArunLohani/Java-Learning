package com.SpringWeb.demo.controller;

import com.SpringWeb.demo.models.Product;
import com.SpringWeb.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return service.getProducts();
    }


    @GetMapping("/products/{prodId}")
    public Product getProduct(@PathVariable int prodId){

        return service.getProductById(prodId);

    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product prod){

        try{
            service.addProduct(prod);
            return "Product added Successfully.";
        } catch (Exception e) {
            return "Something went wrong.";
        }

    }

    @PutMapping("/products/{prodId}")
    public String updateProduct(@PathVariable int prodId ,@RequestBody Product prod){

        try{
            service.updateProduct(prodId,prod);
            return "Product updated Successfully.";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println(e.getCause());
            return "Something went wrong.";
        }

    }

    @DeleteMapping("/products/{prodId}")

    public String deleteProduct(@PathVariable int prodId){
        try{
            service.deleteProduct(prodId);
            return "Product deleted Successfully.";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println(e.getCause());
            return "Something went wrong.";
        }
    }


}
