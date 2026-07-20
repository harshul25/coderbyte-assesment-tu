package com.coderbyte.workspace.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.coderbyte.workspace.item.CartItem;
import com.coderbyte.workspace.publisher.CartChange;
import com.coderbyte.workspace.publisher.CartChangePublisher;
import com.coderbyte.workspace.repository.CartRepository;


@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartChangePublisher cartChangePublisher;

    public CartService(CartRepository cartRepository, CartChangePublisher cartChangePublisher) {
        // add a storage layer to the cart service to save cart items
        this.cartRepository = cartRepository;
        // add a publisher to notify when items are added or removed from the cart (in case we have multiple users or services that make these changes)
        this.cartChangePublisher = cartChangePublisher;
    }

    public Collection<CartItem> getAllItems() {
        // list all items in the cart
        return cartRepository.getAllItems();
    }

    public void addItem(CartItem item) {
        // add an item to the cart
        cartRepository.addItem(item);
        cartChangePublisher.publishCartChange(CartChange.EventType.ADD, item.getId());
    }

    public void removeItem(String productId) {
        // remove an item from the cart by its id
        cartRepository.removeItem(productId);
        cartChangePublisher.publishCartChange(CartChange.EventType.REMOVE, productId);
    }

    
}
