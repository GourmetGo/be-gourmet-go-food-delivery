package com.gourmetGo.dto.response.user;

import com.gourmetGo.model.Order;
import com.gourmetGo.model.Product;

import java.util.List;
import java.util.UUID;

public class RestaurantResponseDto extends UserResponseDto {
    private String name;
    private String address;
    private List<Product> products;
    private List<Order> orders;

    public RestaurantResponseDto(UUID id, String username, String password, String email, String phone, String name, String address, List<Product> products, List<Order> orders) {
        super(id, username, password, email, phone);
        this.name = name;
        this.address = address;
        this.products = products;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
