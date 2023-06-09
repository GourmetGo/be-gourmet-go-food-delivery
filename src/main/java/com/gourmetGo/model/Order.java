package com.gourmetGo.model;

import com.gourmetGo.model.user.Courier;
import com.gourmetGo.model.user.Customer;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courier_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_order_courier"))
    private Courier courier;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(UUID id, String status, List<Product> products, Courier courier) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.courier = courier;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
