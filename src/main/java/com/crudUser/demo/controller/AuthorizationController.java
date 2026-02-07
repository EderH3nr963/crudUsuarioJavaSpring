package com.crudUser.demo.controller;

import com.crudUser.demo.dto.Request.LoginDTO;
import com.crudUser.demo.dto.Response.LoginResponseDTO;
import com.crudUser.demo.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO dto) {
        var token = this.authorizationService.login(dto.getEmail(), dto.getPassword());

        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }
}
