package com.gourmetGo.model.user;

import com.gourmetGo.model.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {
    private String firstname;
    private String lastname;
    private String address;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_customer_order"))
    private List<Order> orders = new ArrayList<>();

    public Customer(String username, String password, String email, String phone, String firstname, String lastname, String address, List<Order> orders) {
        super(username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.orders = orders;
    }

    public Customer() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
