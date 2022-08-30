package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<OrderItem, Integer> cart;
    private static Order order;

    public Order(OrderItem orderItem) {
        this.cart = new HashMap<>();
        cart.put(orderItem, 1);
    }

    public static Order getInstance(OrderItem orderItem) {
        if (order == null) {
            order = new Order(orderItem);
        }
        return order;
    }

    public void addItemToOrder(OrderItem orderItem) {
        if (cart.containsKey(orderItem)) {
            int value = cart.get(orderItem);
            cart.put(orderItem, value + 1);
        } else {
            cart.put(orderItem, 1);
        }
    }

    public int getTotalCartQuantity() {
        return cart.values().stream().reduce(Integer::sum).orElse(0);
    }

}
