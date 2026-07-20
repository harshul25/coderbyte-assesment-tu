package com.coderbyte.workspace.repository;

import org.springframework.stereotype.Repository;

import com.coderbyte.workspace.item.CartItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepository {
    private final Map<String, CartItem> cartItems = new HashMap<>(); // the storage layer for the cart items

    public void addItem(CartItem item) {
        cartItems.put(item.getId(), item);
    }

    public void removeItem(String productId) {
        cartItems.remove(productId);
    }

    public Collection<CartItem> getAllItems() {
        return cartItems.values();
    }
}
