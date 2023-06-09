package com.gourmetGo.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class RestaurantRequestDto extends UserRequestDto{
    @NotBlank(message = "Name is required.")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;
    @NotBlank(message = "Address is required.")
    @Size(min = 3, message = "Address must be at least 3 characters long")
    private String address;

    public RestaurantRequestDto(String username, String password, String email, String phone, String name, String address) {
        super(username, password, email, phone);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
