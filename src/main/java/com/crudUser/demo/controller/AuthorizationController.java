package com.crudUser.demo.controller;

import com.crudUser.demo.dto.Request.LoginDTO;
import com.crudUser.demo.dto.Request.UsuarioCreateDTO;
import com.crudUser.demo.dto.Response.LoginResponseDTO;
import com.crudUser.demo.dto.Response.UsuarioResponseDTO;
import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.service.AuthorizationService;
import com.crudUser.demo.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Autentificação",
        description = "Rotas de login e registro de usuários"
)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private UsuarioService usuarioService;


    @SecurityRequirement(name= "")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO dto) {
        var token = this.authorizationService.login(dto.getEmail(), dto.getPassword());

        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }

    @SecurityRequirement(name = "")
    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody @Valid UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        Usuario saved = usuarioService.create(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponseDTO(saved));
    }

}
