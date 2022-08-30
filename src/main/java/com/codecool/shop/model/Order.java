package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private final Map<OrderItem, Integer> cart;
    private Order order;

    public Order(OrderItem orderItem) {
        this.cart = new HashMap<>();
        cart.put(orderItem, 1);
    }

    public Order getInstance(OrderItem orderItem) {
        if (order == null) {
            order = new Order(orderItem);
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
}
