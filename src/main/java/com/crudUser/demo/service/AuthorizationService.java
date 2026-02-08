package com.crudUser.demo.service;

import com.crudUser.demo.model.Usuario.Usuario;
import com.crudUser.demo.security.TokenService;
import com.crudUser.demo.security.UsuarioDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AuthorizationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String email, String password) {
        System.out.println("O erro ocorreu aqui1");
        var authToken = new UsernamePasswordAuthenticationToken(email, password);

        System.out.println("O erro ocorreu aqui2");
        var auth = authenticationManager.authenticate(authToken);

        System.out.println("O erro ocorreu aqui3");
        return tokenService.generateToken(
                (UsuarioDetailsImpl) auth.getPrincipal()
        );
    }

}
