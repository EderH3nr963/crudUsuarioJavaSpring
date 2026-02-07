package com.crudUser.demo.service;

import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    private Usuario usuarioExistingAndReturn(UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Usuário não encontrado")
                );
    }

    public Usuario create(Usuario usuario) {
        if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

        if (usuario.getEmail() == null || usuario.getUsername() == null) {
            throw new IllegalArgumentException("Email e nome de usuário obrigatório");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new IllegalArgumentException("Nome de usuário já cadastrado");
        }

        usuario.setHashPassword(encoder.encode(usuario.getPassword()));
        usuario.setPassword(null);

        return usuarioRepository.save(usuario);
    }

    public Usuario read(UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    @Transactional
    public Usuario updateEmail(UUID id, String newEmail) {
        Usuario usuario = usuarioExistingAndReturn(id);
        usuario.setEmail(newEmail);

        return usuario;
    }

    @Transactional
    public Usuario updateUsername(UUID id, String newUsername) {
        Usuario usuario = usuarioExistingAndReturn(id);
        usuario.setUsername(newUsername);

        return usuario;
    }

    @Transactional
    public Usuario updatePassword(UUID id, String newPassword) {
        Usuario usuario = usuarioExistingAndReturn(id);
        usuario.setHashPassword(encoder.encode(newPassword));

        return usuario;
    }

    public void delete(UUID id) {
        Usuario usuario = usuarioExistingAndReturn(id);

        usuarioRepository.delete(usuario);
    }
}
