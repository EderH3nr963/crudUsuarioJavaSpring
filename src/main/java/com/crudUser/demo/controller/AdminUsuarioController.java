package com.crudUser.demo.controller;

import com.crudUser.demo.dto.Request.UpdateEmailDTO;
import com.crudUser.demo.dto.Request.UpdatePasswordDTO;
import com.crudUser.demo.dto.Request.UpdateUsernameDTO;
import com.crudUser.demo.dto.Response.UsuarioResponseDTO;
import com.crudUser.demo.dto.Response.UsuariosResponseDTO;
import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.security.UsuarioDetailsImpl;
import com.crudUser.demo.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Tag(
        name = "Administração de Usuários",
        description = "Rota para administradores atualizarem usuários"
)
@RestController
@RequestMapping("/api/v1/admin/user")
public class AdminUsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> get(
            @PathVariable String id
    ) {
        Usuario usuario = usuarioService.read(UUID.fromString(id));
        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<UsuariosResponseDTO> getAll() {
        Collection<Usuario> response = usuarioService.readAll();

        return ResponseEntity.ok(new UsuariosResponseDTO(response));
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<UsuarioResponseDTO> updateEmail(
            @PathVariable String id,
            @Valid @RequestBody UpdateEmailDTO dto
    ) {
        Usuario updated =
                usuarioService.updateEmail(UUID.fromString(id), dto.getEmail());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/{id}/username")
    public ResponseEntity<UsuarioResponseDTO> updateUsername(
            @PathVariable String id,
            @Valid @RequestBody UpdateUsernameDTO dto
    ) {
        Usuario updated =
                usuarioService.updateUsername(UUID.fromString(id), dto.getUsername());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UsuarioResponseDTO> updatePassword(
            @PathVariable String id,
            @Valid @RequestBody UpdatePasswordDTO dto
    ) {
        Usuario updated =
                usuarioService.updatePassword(UUID.fromString(id), dto.getPassword());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id
    ) {
        usuarioService.delete(UUID.fromString(id));
    }
}
