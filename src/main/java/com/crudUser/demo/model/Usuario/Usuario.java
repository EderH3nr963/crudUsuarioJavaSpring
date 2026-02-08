package com.crudUser.demo.model.Usuario;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name="hash_password")
    private String hashPassword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioRole role = UsuarioRole.USER;

    @Transient
    private String password;

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UsuarioRole getRole() { return role; }
    public void setRole(UsuarioRole role) { this.role = role; }

    public void setHashPassword(String hashPassword) { this.hashPassword = hashPassword; }
    public String getHashPassword() { return this.hashPassword; }
}
