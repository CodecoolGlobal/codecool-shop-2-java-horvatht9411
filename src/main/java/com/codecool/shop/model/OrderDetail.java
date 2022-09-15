package com.codecool.shop.model;

public class OrderDetail extends BaseModel{

    private int productId;
    private int quantity;
    private int cartId;

    public OrderDetail(int productId, int quantity, int cartId) {
        this.productId = productId;
        this.quantity = quantity;
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCartId() {
        return cartId;
    }
}
