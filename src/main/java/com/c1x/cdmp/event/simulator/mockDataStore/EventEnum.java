package com.c1x.cdmp.event.simulator.mockDataStore;


import lombok.Getter;

@Getter
public enum EventEnum {
    MRO_CART_ABANDONED("mro-cart-abandoned"),
    MRO_BACK_IN_STOCK("mro-back-in-stock");
    private final String eventName;

    EventEnum(String eventName) {
        this.eventName = eventName;
    }

}
