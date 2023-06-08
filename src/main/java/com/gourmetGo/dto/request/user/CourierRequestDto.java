package com.gourmetGo.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourierRequestDto extends UserRequestDto {
    @NotBlank(message = "Firstname is required.")
    @Size(min = 3, message = "Firstname must be at least 3 characters long")
    private String firstname;
    @NotBlank(message = "Lastname is required.")
    @Size(min = 3, message = "Lastname must be at least 3 characters long")
    private String lastname;

    public CourierRequestDto() {
    }

    public CourierRequestDto(String username, String password, String email, String phone, String firstname, String lastname) {
        super(username, password, email, phone);
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
