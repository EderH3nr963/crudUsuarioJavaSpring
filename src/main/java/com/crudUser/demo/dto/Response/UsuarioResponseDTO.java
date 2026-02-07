package com.crudUser.demo.dto.Response;

import com.crudUser.demo.model.Usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioResponseDTO {
    @NotBlank
    private String username;

    @NotNull
    private String email;

    public UsuarioResponseDTO(Usuario usuario) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
