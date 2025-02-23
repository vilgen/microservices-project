package com.mapkloud.inventory_service.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //stock keeping unit code
    private String skuCode;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public static final class InventoryBuilder {
        private Long id;
        private String skuCode;
        private Integer quantity;

        public InventoryBuilder() {
        }

        public InventoryBuilder(Inventory other) {
            this.id = other.id;
            this.skuCode = other.skuCode;
            this.quantity = other.quantity;
        }

        public static InventoryBuilder anInventory() {
            return new InventoryBuilder();
        }

        public InventoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InventoryBuilder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public InventoryBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Inventory build() {
            Inventory inventory = new Inventory();
            inventory.quantity = this.quantity;
            inventory.skuCode = this.skuCode;
            inventory.id = this.id;
            return inventory;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(skuCode, inventory.skuCode) && Objects.equals(quantity, inventory.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuCode, quantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", skuCode='" + skuCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
