package com.gourmetGo.dto.response.user;

import com.gourmetGo.model.Order;

import java.util.List;
import java.util.UUID;

public class CustomerResponseDto extends UserResponseDto {
    private String firstname;
    private String lastname;
    private String address;
    private List<Order> orders;

    public CustomerResponseDto(UUID id, String username, String password, String firstname, String lastname, String email, String phone, String address, List<Order> orders) {
        super(id, username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.orders = orders;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
