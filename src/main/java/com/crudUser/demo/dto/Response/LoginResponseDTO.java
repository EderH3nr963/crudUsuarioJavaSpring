package com.crudUser.demo.dto.Response;

import jakarta.validation.constraints.NotNull;

public class LoginResponseDTO {
    @NotNull
    private String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
