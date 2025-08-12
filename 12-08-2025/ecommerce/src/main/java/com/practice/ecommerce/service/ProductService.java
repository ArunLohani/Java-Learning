package com.practice.ecommerce.service;


import com.practice.ecommerce.model.Product;
import com.practice.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){

        return repo.findAll();


    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public Product getProductById(int prodId){

        return repo.findById(prodId).orElse(null);

    }

    public void updateProduct(Product prod){

        repo.save(prod);


    }

    public void deleteProduct(int prodId){
        repo.deleteById(prodId);
    }


    public List<Product> searchProducts(String keyword){

        return repo.searchProducts(keyword);

    }

}
