package com.mapkloud.product_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductResponse {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public static final class ProductResponseBuilder {
        private String id;
        private String name;
        private String description;
        private BigDecimal price;

        public ProductResponseBuilder() {
        }

        public ProductResponseBuilder(ProductResponse other) {
            this.id = other.id;
            this.name = other.name;
            this.description = other.description;
            this.price = other.price;
        }

        public static ProductResponseBuilder aProductResponse() {
            return new ProductResponseBuilder();
        }

        public ProductResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductResponse build() {
            ProductResponse productResponse = new ProductResponse();
            productResponse.id = this.id;
            productResponse.price = this.price;
            productResponse.name = this.name;
            productResponse.description = this.description;
            return productResponse;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
