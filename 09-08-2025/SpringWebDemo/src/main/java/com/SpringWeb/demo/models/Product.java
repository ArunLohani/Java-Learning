package com.SpringWeb.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private int price;


    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public int getPrice() {
        return price;
    }



    public Product(){


    }

    public Product(int id,String name , int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }



}
