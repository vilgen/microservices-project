package com.mapkloud.order_service.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemsList() {
        return orderLineItemsList;
    }


    public static final class OrderBuilder {
        private Long id;
        private String orderNumber;
        private List<OrderLineItems> orderLineItemsList;

        public OrderBuilder() {
        }

        public OrderBuilder(Order other) {
            this.id = other.id;
            this.orderNumber = other.orderNumber;
            this.orderLineItemsList = other.orderLineItemsList;
        }

        public static OrderBuilder anOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderBuilder orderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrderBuilder orderLineItemsList(List<OrderLineItems> orderLineItemsList) {
            this.orderLineItemsList = orderLineItemsList;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.orderNumber = this.orderNumber;
            order.orderLineItemsList = this.orderLineItemsList;
            order.id = this.id;
            return order;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderNumber, order.orderNumber) && Objects.equals(orderLineItemsList, order.orderLineItemsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, orderLineItemsList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderLineItemsList=" + orderLineItemsList +
                '}';
    }
}
