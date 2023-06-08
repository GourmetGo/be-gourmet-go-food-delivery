package com.gourmetGo.dto.response.user;

import java.util.UUID;

public class CustomerResponseDto extends UserResponseDto {
    private String firstname;
    private String lastname;
    private String address;

    public CustomerResponseDto(UUID id, String username, String password, String firstname, String lastname, String email, String phone, String address) {
        super(id, username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
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
}
