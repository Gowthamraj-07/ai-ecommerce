package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Product;
import com.example.backend.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
public class ProductController {
    
    @Autowired
    ProductService service;

    @GetMapping("/getall")
    public List<Product> getMethodName() {
        return service.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getMethodName(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping("/add")
    public Product postMethodName(@RequestBody Product p) {
        return service.addProduct(p);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMethod(@PathVariable Long id)
    {
        return service.deleteProductById(id);
    }
    
    
    
}
