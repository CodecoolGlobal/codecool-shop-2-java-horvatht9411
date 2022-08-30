package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private final Map<OrderItem, Integer> cart;
    private static Order order;

    public Order() {
        this.cart = new HashMap<>();
    }

    public static Order getInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    private boolean hasItem(OrderItem orderItem) {
        for (OrderItem item : cart.keySet()) {
            if (item == orderItem) {
                return true;
            }
        }
        return false;
    }

    public void addItemToOrder(OrderItem orderItem) {
        if (hasItem(orderItem)) {
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
