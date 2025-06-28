package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.CartDTO;
import com.example.backend.model.CartItem;
import com.example.backend.service.CartService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin
public class CartController {
    @Autowired
    CartService ser;
    @PostMapping("/addcart")
    public String postMethodName(@RequestBody CartDTO cart) {
        //TODO: process POST request
        return ser.addToCart(cart.getUserId(), cart.getProductId(), cart.getQuantity());
    
        
    }
    @GetMapping("/getcart/{userid}")
    public List<CartItem> getMethodName(@PathVariable Long userid) {
        return ser.findCartByuser(userid);
    }
    
    
}
