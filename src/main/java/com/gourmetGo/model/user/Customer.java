package com.gourmetGo.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends User {
    private String firstname;
    private String lastname;
    private String address;

    public Customer(String username, String password, String firstname, String lastname, String email, String phone, String address) {
        super(username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
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
}
