package com.mapkloud.order_service.util;

import com.mapkloud.order_service.dto.OrderLineItemsDto;
import com.mapkloud.order_service.model.OrderLineItems;

public final class OrderHelper {

    public static OrderLineItems mapDtoToOrderLineItems (OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.OrderLineItemsBuilder.anOrderLineItems()
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();
    }
}
