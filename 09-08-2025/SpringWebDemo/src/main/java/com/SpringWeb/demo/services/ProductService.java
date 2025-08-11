package com.SpringWeb.demo.services;


import com.SpringWeb.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1 , "Iphone13",35000),
            new Product(2 , "MacBook",120000),
            new Product(3 , "Moto Neo Edge 50",20000
            )));




    public List<Product> getProducts(){

        return products;


    }

    public Product getProductById(int prodId){

        return products.stream().filter(a->a.getId() == prodId).findFirst().get();


    }

    public void addProduct(Product prod){

        products.add(prod);
    }

    public void updateProduct(int prodId , Product prod){

        Product selectedProd = products.stream().filter(a ->prodId == a.getId()).findFirst().get();

        products.set(selectedProd.getId()-1,prod);


    }

    public void deleteProduct(int prodId){

        Product selectedProd = products.stream().filter(a ->prodId == a.getId()).findFirst().get();

        products.remove(selectedProd.getId()-1);

    }

}
