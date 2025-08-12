package com.SpringWeb.demo.services;


import com.SpringWeb.demo.models.Product;
import com.SpringWeb.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepo repo;





    public List<Product> getProducts(){

        return repo.findAll();


    }

    public Product getProductById(int prodId){

        return repo.findById(prodId).orElse(new Product(0,"No Product" , 0));


    }

    public void addProduct(Product prod){

        repo.save(prod);
    }

    public void updateProduct(int prodId , Product prod){

        repo.save(prod);


    }

    public void deleteProduct(int prodId){

            repo.deleteById(prodId);

    }

}
