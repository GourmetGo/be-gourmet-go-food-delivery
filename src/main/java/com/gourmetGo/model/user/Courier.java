package com.gourmetGo.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "couriers")
public class Courier extends User{
    private String firstname;
    private String lastname;


    public Courier() {}

    public Courier(String username, String password, String email, String phone, String firstname, String lastname) {
        super(username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
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
}
