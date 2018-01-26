package com.infoshare.junit.warehouse;

import java.util.stream.Collectors;

public class SimpleOrderReporter implements OrderReporter {
    public SimpleOrderReporter(OrderService service) {
    }

    @Override
    public Summary summarize(OrderService service) {
        Summary summary = new Summary();
        summary.total = service.getOrders().stream().mapToInt(o -> o.getAmount()).sum();
        return summary;
    }
}
