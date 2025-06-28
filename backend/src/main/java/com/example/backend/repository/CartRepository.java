package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem>findByUserId(Long userId);
    CartItem findByUserIdAndProductId(Long userid,Long productId);

    
}
