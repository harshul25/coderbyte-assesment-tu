package com.coderbyte.workspace.publisher;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationEventPublisher;

@Component
public class CartChangePublisher {
    private final ApplicationEventPublisher eventPublisher;

    public CartChangePublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishCartChange(CartChange.EventType eventType, String productId) {
        CartChange cartChange = new CartChange(eventType, productId);
        eventPublisher.publishEvent(cartChange);
    }
}
