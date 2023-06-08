package com.gourmetGo.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant extends User{
    private String name;
    private String address;

    public Restaurant() {
    }

    public Restaurant(String username, String password, String email, String phone, String name, String address) {
        super(username, password, email, phone);
        this.name = name;
        this.address = address;
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
}
