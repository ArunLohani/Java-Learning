package com.practice.ecommerce.controller;
import com.practice.ecommerce.model.Product;
import com.practice.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
        Product product = service.getProductById(prodId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/products/{prodId}")
    public ResponseEntity<Void> updateProduct(@PathVariable int prodId, @RequestBody Product prod) {
        Product existingProduct = service.getProductById(prodId);
        if (existingProduct != null) {
            service.updateProduct(prod);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/products/{prodId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int prodId) {
        Product existingProduct = service.getProductById(prodId);
        if (existingProduct != null) {
            service.deleteProduct(prodId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){

        return new ResponseEntity<>(service.searchProducts(keyword),HttpStatus.OK);


    }
}














