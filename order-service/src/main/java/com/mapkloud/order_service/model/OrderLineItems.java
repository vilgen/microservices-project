package com.mapkloud.order_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "t_order_line_items")
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //stock keeping unit code
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


    public static final class OrderLineItemsBuilder {
        private Long id;
        private String skuCode;
        private BigDecimal price;
        private Integer quantity;

        public OrderLineItemsBuilder() {
        }

        public OrderLineItemsBuilder(OrderLineItems other) {
            this.id = other.id;
            this.skuCode = other.skuCode;
            this.price = other.price;
            this.quantity = other.quantity;
        }

        public static OrderLineItemsBuilder anOrderLineItems() {
            return new OrderLineItemsBuilder();
        }

        public OrderLineItemsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderLineItemsBuilder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public OrderLineItemsBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderLineItemsBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderLineItems build() {
            OrderLineItems orderLineItems = new OrderLineItems();
            orderLineItems.quantity = this.quantity;
            orderLineItems.id = this.id;
            orderLineItems.skuCode = this.skuCode;
            orderLineItems.price = this.price;
            return orderLineItems;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItems that = (OrderLineItems) o;
        return Objects.equals(id, that.id) && Objects.equals(skuCode, that.skuCode) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuCode, price, quantity);
    }

    @Override
    public String toString() {
        return "OrderLineItems{" +
                "id=" + id +
                ", skuCode='" + skuCode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
