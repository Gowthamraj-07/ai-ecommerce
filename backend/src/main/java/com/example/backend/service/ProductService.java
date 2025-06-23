package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public Product addProduct(Product p)
    {
        return repo.save(p);
    }
    public Product getProductById(Long id)
    {
        return repo.findById(id).orElse(null);
    }
    public String deleteProductById(Long id)
    {
        if(repo.existsById(id))
        {
            repo.deleteById(id);
            return "Deleted";
        }
        else{
            return "Product not found";
        }
    }
}
