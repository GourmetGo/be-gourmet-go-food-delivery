package com.gourmetGo.dto.response.user;

import java.util.UUID;

public class CourierResponseDto extends UserResponseDto {
    private String firstname;
    private String lastname;

    public CourierResponseDto(UUID id, String username, String password, String email, String phone, String firstname, String lastname) {
        super(id, username, password, email, phone);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
