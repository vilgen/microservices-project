package com.mapkloud.inventory_service.dto;

import java.util.Objects;

public class InventoryResponse {

    private String skuCode;

    private boolean isInStock;

    public String getSkuCode() {
        return skuCode;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public static final class InventoryResponseBuilder {
        private String skuCode;
        private boolean isInStock;

        public InventoryResponseBuilder() {
        }

        public InventoryResponseBuilder(InventoryResponse other) {
            this.skuCode = other.skuCode;
            this.isInStock = other.isInStock;
        }

        public static InventoryResponseBuilder anInventoryResponse() {
            return new InventoryResponseBuilder();
        }

        public InventoryResponseBuilder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public InventoryResponseBuilder isInStock(boolean isInStock) {
            this.isInStock = isInStock;
            return this;
        }

        public InventoryResponse build() {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.skuCode = this.skuCode;
            inventoryResponse.isInStock = this.isInStock;
            return inventoryResponse;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InventoryResponse that = (InventoryResponse) o;
        return isInStock == that.isInStock && Objects.equals(skuCode, that.skuCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuCode, isInStock);
    }

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "skuCode='" + skuCode + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
