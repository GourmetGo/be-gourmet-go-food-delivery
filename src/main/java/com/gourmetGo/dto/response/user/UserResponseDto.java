package com.gourmetGo.dto.response.user;

import java.util.UUID;

public abstract class UserResponseDto {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public UserResponseDto(UUID id, String username, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
