package com.infoshare.junit.warehouse;

public class EmptyOrder implements Order {

    @Override
    public Integer getAmount() {
        return 0;
    }

    @Override
    public Integer getPrice() {
        return 0;
    }
}
