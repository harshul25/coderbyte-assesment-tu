package com.coderbyte.workspace.publisher;

public class CartChange {
    public enum EventType {
        ADD,
        REMOVE
    }
    
    private final EventType eventType;
    private final String productId;

    public CartChange(EventType eventType, String productId) {
        this.eventType = eventType;
        this.productId = productId;
    }

    public EventType getEventType() {
        return eventType;
    }
    public String getProductId() {
        return productId;
    }
}
