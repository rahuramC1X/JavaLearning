package com.c1x.cdmp.event.simulator.mockDataStore;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Data
public class Event {
    private String userId;
    private String type;

    private EventEnum event;
    private List<Product> productList;
    private Date timestamp;

    public Event(){}
    public Event(String userId, String type, EventEnum event, List<Product> productList, Date timestamp) {
        this.userId = userId;
        this.type = type;
        this.event = event;
        this.productList = productList;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "userId:'" + userId + '\'' +
                ", type:'" + type + '\'' +
                ", event:'" + event + '\'' +
                ", properties:{products:" + productList + "}"+
                ", timestamp=" + timestamp +
                '}';
    }


}
