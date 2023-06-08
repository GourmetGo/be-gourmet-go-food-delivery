package com.gourmetGo.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerRequestDto extends UserRequestDto {

    @NotBlank(message = "Firstname is required.")
    @Size(min = 3, message = "Firstname must be at least 3 characters long")
    private String firstname;
    @NotBlank(message = "Lastname is required.")
    @Size(min = 3, message = "Lastname must be at least 3 characters long")
    private String lastname;

    @NotNull
    private String address;

    public CustomerRequestDto(String username, String password, String firstname, String lastname, String email, String phone, String address) {
        super(username, password, email, phone);
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
