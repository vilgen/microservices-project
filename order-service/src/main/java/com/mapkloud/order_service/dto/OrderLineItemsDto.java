package com.mapkloud.order_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderLineItemsDto {

    private Long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public static final class OrderLineItemsDtoBuilder {
        private Long id;
        private String skuCode;
        private BigDecimal price;
        private Integer quantity;

        public OrderLineItemsDtoBuilder() {
        }

        public OrderLineItemsDtoBuilder(OrderLineItemsDto other) {
            this.id = other.id;
            this.skuCode = other.skuCode;
            this.price = other.price;
            this.quantity = other.quantity;
        }

        public static OrderLineItemsDtoBuilder anOrderLineItemsDto() {
            return new OrderLineItemsDtoBuilder();
        }

        public OrderLineItemsDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderLineItemsDtoBuilder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public OrderLineItemsDtoBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderLineItemsDtoBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderLineItemsDto build() {
            OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
            orderLineItemsDto.skuCode = this.skuCode;
            orderLineItemsDto.id = this.id;
            orderLineItemsDto.quantity = this.quantity;
            orderLineItemsDto.price = this.price;
            return orderLineItemsDto;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItemsDto that = (OrderLineItemsDto) o;
        return Objects.equals(id, that.id) && Objects.equals(skuCode, that.skuCode) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuCode, price, quantity);
    }

    @Override
    public String toString() {
        return "OrderLineItemsDto{" +
                "id=" + id +
                ", skuCode='" + skuCode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
