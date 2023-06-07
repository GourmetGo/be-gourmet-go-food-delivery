package com.gourmetGo.dto.response;

import java.util.UUID;

public class UserResponseDto {
    private UUID id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public UserResponseDto(UUID id, String username, String password, String firstname, String lastname, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
