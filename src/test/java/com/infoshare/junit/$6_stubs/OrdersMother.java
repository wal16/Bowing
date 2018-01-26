package com.infoshare.junit.$6_stubs;

import com.infoshare.junit.warehouse.EmptyOrder;
import com.infoshare.junit.warehouse.Order;
import com.infoshare.junit.warehouse.OrderService;
import com.infoshare.junit.warehouse.StandardOrder;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

public class OrdersMother {
    private int count;
    private int value;

    public static OrdersMother sampleOrders(int count) {
        OrdersMother ordersMother = new OrdersMother();
        ordersMother.count = count;
        return ordersMother;
    }

    public OrdersMother ofValue(int value) {
        this.value = value;
        return this;
    }

    public List<Order> build() {
        List<Order> orders = new ArrayList<>();
        for (int i=0;i<count;i++) {
            orders.add(new StandardOrder());
            orders.add(new StandardOrder());
            orders.add(new EmptyOrder());
        }
        return orders;
    }
}
