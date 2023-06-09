package com.gourmetGo.model.user;

import com.gourmetGo.model.Order;
import com.gourmetGo.model.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends User{
    private String name;
    private String address;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_restaurant_product"))
    private List<Product> products = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_restaurant_order"))
    private List<Order> orders = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String username, String password, String email, String phone, String name, String address, List<Product> products, List<Order> orders) {
        super(username, password, email, phone);
        this.name = name;
        this.address = address;
        this.products = products;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
