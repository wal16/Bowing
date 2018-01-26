package com.infoshare.junit.$6_stubs;

import com.infoshare.junit.warehouse.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderReporterTest {

    @Test
    public void reporter_should_contain_total_value() {

        // given
        OrderDatabase orderDatabase = new SlowOrderDatabase();
        WarehouseConnector warehouseConnector = new SlowWarehouseConnector();
        OrderService service = new OrderService(orderDatabase, warehouseConnector);
        OrderReporter reporter = new SimpleOrderReporter(service);

        // when
        Summary summary = reporter.summarize(service);

        // then
        assertThat(summary.total).isEqualTo(10);
    }

    @Test
    public void reporter_with_mockService_should_contain_total_value() {
        // given
        List<Order> orders = OrdersMother.sampleOrders(100).ofValue(2).build();
        OrderService service = mock(OrderService.class);
        when(service.getOrders()).thenReturn(orders);
        OrderReporter reporter = new SimpleOrderReporter(service);

        // when
        Summary summary = reporter.summarize(service);

        // then
        assertThat(summary.total).isEqualTo(2000);
    }

    @Test
    public void shouldMatchSimpleArgument() {

        // given
        LocalDate wantedDate = LocalDate.of(2017,12,24);
        ShippingScheduler schedulerMock = mock(ShippingScheduler.class);
        when(
                schedulerMock.getNumberOfOrdersScheduledOnDate(wantedDate)
        ).thenReturn(173);

        // when
        int numberForWantedArgument = schedulerMock.getNumberOfOrdersScheduledOnDate(wantedDate);
        int numberForAnyOtherArgument = schedulerMock.getNumberOfOrdersScheduledOnDate(any());

        // then
        assertThat(numberForWantedArgument).isEqualTo(173);
        assertThat(numberForAnyOtherArgument).isEqualTo(0);  //default value for int
    }



}
