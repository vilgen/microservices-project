package com.mapkloud.order_service.service;

import com.mapkloud.order_service.dto.InventoryResponse;
import com.mapkloud.order_service.dto.OrderRequest;
import com.mapkloud.order_service.model.Order;
import com.mapkloud.order_service.model.OrderLineItems;
import com.mapkloud.order_service.repository.OrderRepository;
import com.mapkloud.order_service.util.OrderHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;

    public OrderService(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }

    public void placeOrder(OrderRequest orderRequest) {

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(OrderHelper::mapDtoToOrderLineItems)
                .toList();

        Order order = Order.OrderBuilder.anOrder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItems)
                .build();

        List<String> skuCodes = orderLineItems.stream().map(OrderLineItems::getSkuCode).toList();

        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponses))
                .allMatch(InventoryResponse::isInStock);

        if (!allProductsInStock) {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        } else {
            orderRepository.save(order);
        }
    }
}
