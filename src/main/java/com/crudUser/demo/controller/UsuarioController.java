package com.crudUser.demo.controller;

import com.crudUser.demo.dto.Request.*;
import com.crudUser.demo.dto.Response.UsuarioResponseDTO;
import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.security.UsuarioDetailsImpl;
import com.crudUser.demo.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(
        name="Usuário",
        description = "Rota para usuários conseguirem manipular seu dados"
)
@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> me(
            @AuthenticationPrincipal UsuarioDetailsImpl user
    ) {
        Usuario usuario = usuarioService.read(user.getId());
        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));
    }

    @PatchMapping("/email")
    public ResponseEntity<UsuarioResponseDTO> updateEmail(
            @AuthenticationPrincipal UsuarioDetailsImpl user,
            @Valid @RequestBody UpdateEmailDTO dto
    ) {
        Usuario updated =
                usuarioService.updateEmail(user.getId(), dto.getEmail());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/username")
    public ResponseEntity<UsuarioResponseDTO> updateUsername(
            @AuthenticationPrincipal UsuarioDetailsImpl user,
            @Valid @RequestBody UpdateUsernameDTO dto
    ) {
        Usuario updated =
                usuarioService.updateUsername(user.getId(), dto.getUsername());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @PatchMapping("/password")
    public ResponseEntity<UsuarioResponseDTO> updatePassword(
            @AuthenticationPrincipal UsuarioDetailsImpl user,
            @Valid @RequestBody UpdatePasswordDTO dto
    ) {
        Usuario updated =
                usuarioService.updatePassword(user.getId(), dto.getPassword());

        return ResponseEntity.ok(new UsuarioResponseDTO(updated));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @AuthenticationPrincipal UsuarioDetailsImpl user
    ) {
        usuarioService.delete(user.getId());
    }
}

