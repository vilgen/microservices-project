package com.mapkloud.order_service.event;

import java.util.Objects;

public class OrderPlacedEvent {

    private String orderNumber;

    public OrderPlacedEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderPlacedEvent that = (OrderPlacedEvent) o;
        return Objects.equals(orderNumber, that.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderNumber);
    }

    @Override
    public String toString() {
        return "OrderPlacedEvent{" +
                "orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
