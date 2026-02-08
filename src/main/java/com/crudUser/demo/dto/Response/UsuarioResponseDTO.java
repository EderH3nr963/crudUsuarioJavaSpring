package com.crudUser.demo.dto.Response;

import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.model.Usuario.UsuarioRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioResponseDTO {
    @NotBlank
    private String username;

    @NotNull
    private String email;

    @NotNull
    private UsuarioRole role;

    public UsuarioResponseDTO(Usuario usuario) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.role = usuario.getRole();
    }

    public UsuarioRole getRole() { return role; }
    public void setRole(UsuarioRole role) { this.role = role; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
