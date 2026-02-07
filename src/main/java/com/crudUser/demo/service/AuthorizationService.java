package com.crudUser.demo.service;

import com.crudUser.demo.security.UsuarioDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String email, String password) {
        var authToken =
                new UsernamePasswordAuthenticationToken(email, password);

        var auth = authenticationManager.authenticate(authToken);

        return tokenService.generateToken(
                (UsuarioDetailsImpl) auth.getPrincipal()
        );
    }
}
