package com.crudUser.demo.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UpdateEmailDTO {
    @Email
    @NotNull
    private String email;

    public String getEmail() { return email; }
}
