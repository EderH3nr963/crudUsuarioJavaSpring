package com.crudUser.demo.controller;

import com.crudUser.demo.dto.Request.*;
import com.crudUser.demo.dto.Response.UsuarioResponseDTO;
import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/user")
@RestController()
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());
        usuario.setUsername(dto.getUsername());

        Usuario saved = usuarioService.create(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponseDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable UUID id) {
        Usuario usuario = usuarioService.read(id);

        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponseDTO(usuario));
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<UsuarioResponseDTO> updateEmail(@PathVariable UUID id, @Valid @RequestBody UpdateEmailDTO dto) {
        Usuario updated = usuarioService.updateEmail(id, dto.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/{id}/username")
    public ResponseEntity<UsuarioResponseDTO> updateUsername(@PathVariable UUID id, @Valid @RequestBody UpdateUsernameDTO dto) {
        Usuario updated = usuarioService.updateUsername(id, dto.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UsuarioResponseDTO> updatePassword(@PathVariable UUID id, @Valid @RequestBody UpdatePasswordDTO dto) {
        Usuario updated = usuarioService.updatePassword(id, dto.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}
