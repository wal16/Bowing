package com.infoshare.junit.warehouse;

public class StandardOrder implements Order {
    @Override
    public Integer getAmount() {
        return 10;
    }

    @Override
    public Integer getPrice() {
        return 10;
    }

}
