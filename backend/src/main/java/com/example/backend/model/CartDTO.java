package com.example.backend.model;


public class CartDTO {
    Long userId;
    Long ProductId;
    int quantity;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getProductId() {
        return ProductId;
    }
    public void setProductId(Long productId) {
        ProductId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
