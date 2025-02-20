package com.mapkloud.product_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductRequest {

    private String name;

    private String description;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public static final class ProductRequestBuilder {
        private String name;
        private String description;
        private BigDecimal price;

        public ProductRequestBuilder() {
        }

        public ProductRequestBuilder(ProductRequest other) {
            this.name = other.name;
            this.description = other.description;
            this.price = other.price;
        }

        public static ProductRequestBuilder aProductRequest() {
            return new ProductRequestBuilder();
        }

        public ProductRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductRequestBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductRequest build() {
            ProductRequest productRequest = new ProductRequest();
            productRequest.name = this.name;
            productRequest.description = this.description;
            productRequest.price = this.price;
            return productRequest;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
