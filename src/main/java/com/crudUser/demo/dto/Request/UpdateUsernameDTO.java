package com.crudUser.demo.dto.Request;

import jakarta.validation.constraints.NotBlank;

public class UpdateUsernameDTO {
    @NotBlank
    private String username;

    public String getUsername() { return username; }
}
