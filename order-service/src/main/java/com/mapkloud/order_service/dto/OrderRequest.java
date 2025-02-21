package com.mapkloud.order_service.dto;

import java.util.List;
import java.util.Objects;

public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;

    public List<OrderLineItemsDto> getOrderLineItemsDtoList() {
        return orderLineItemsDtoList;
    }


    public static final class OrderRequestBuilder {
        private List<OrderLineItemsDto> orderLineItemsDtoList;

        public OrderRequestBuilder() {
        }

        public OrderRequestBuilder(OrderRequest other) {
            this.orderLineItemsDtoList = other.orderLineItemsDtoList;
        }

        public static OrderRequestBuilder anOrderRequest() {
            return new OrderRequestBuilder();
        }

        public OrderRequestBuilder orderLineItemsDtoList(List<OrderLineItemsDto> orderLineItemsDtoList) {
            this.orderLineItemsDtoList = orderLineItemsDtoList;
            return this;
        }

        public OrderRequest build() {
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.orderLineItemsDtoList = this.orderLineItemsDtoList;
            return orderRequest;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(orderLineItemsDtoList, that.orderLineItemsDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderLineItemsDtoList);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLineItemsDtoList=" + orderLineItemsDtoList +
                '}';
    }
}
