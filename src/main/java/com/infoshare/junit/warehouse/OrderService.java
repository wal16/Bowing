package com.infoshare.junit.warehouse;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class OrderService {

    private final OrderDatabase database;
    private final WarehouseConnector connector;

    public OrderService(OrderDatabase database, WarehouseConnector connector) {
        this.database = database;
        this.connector = connector;
    }

    public List<Order> getOrders() {
        return ImmutableList.of(new EmptyOrder(), new StandardOrder(), new EmptyOrder());
    }

}

