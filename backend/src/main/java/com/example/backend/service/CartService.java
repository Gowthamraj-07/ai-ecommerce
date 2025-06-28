package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.CartItem;
import com.example.backend.model.Product;
import com.example.backend.model.User;
import com.example.backend.repository.CartRepository;
import com.example.backend.repository.ProductRepo;
import com.example.backend.repository.UserRepo;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo proRepo;

    public String addToCart(Long userid,Long productid,int quantity)
    {
        User user=userRepo.findById(userid).orElse(null);
        Product pro=proRepo.findById(productid).orElse(null);
        CartItem exist=cartRepo.findByUserIdAndProductId(userid,productid);
        if(exist!=null)
        {
            exist.setQuantity(exist.getQuantity()+quantity);
            cartRepo.save(exist);
            return "cart item added";
        }
        CartItem item=new CartItem(pro,user,quantity);
        cartRepo.save(item);
        return "CartItem added";
    }

    public List<CartItem> findCartByuser(Long userid)
    {
        return cartRepo.findByUserId(userid);
    }
    public void deleteItem(Long cartid)
    {
        cartRepo.deleteById(cartid);
    }
}
