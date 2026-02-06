package com.crudUser.demo.dto.Request;

import jakarta.validation.constraints.NotBlank;

public class UpdatePasswordDTO {
    @NotBlank
    private String password;

    public String getPassword() { return password; }
}
