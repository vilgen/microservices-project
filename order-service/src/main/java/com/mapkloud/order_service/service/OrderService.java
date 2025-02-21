package com.mapkloud.order_service.service;

import com.mapkloud.order_service.dto.OrderRequest;
import com.mapkloud.order_service.model.Order;
import com.mapkloud.order_service.model.OrderLineItems;
import com.mapkloud.order_service.repository.OrderRepository;
import com.mapkloud.order_service.util.OrderHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest orderRequest) {

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(OrderHelper::mapDtoToOrderLineItems)
                .toList();

        Order order = Order.OrderBuilder.anOrder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItems)
                .build();

        orderRepository.save(order);
    }
}
