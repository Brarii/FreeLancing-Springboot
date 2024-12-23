package com.example.newproj.Services;

import com.example.newproj.Entities.Entities.AuthenticationRequest;
import com.example.newproj.Entities.Entities.AuthnticationResponse;
import com.example.newproj.config.JWTService;
import com.example.newproj.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Builder
@Service
@AllArgsConstructor
public class authservice {
    private final AppUserRepository ar;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JWTService js;


    public AuthnticationResponse authenticate(AuthenticationRequest authenticationRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (authenticationRequest.getEmail(),
                                authenticationRequest.getPassword())
        );
        var user = ar.findByUsername(authenticationRequest.getEmail());
        var jwttoken = js.generatetoken
                ( user);


        return AuthnticationResponse.builder()
                .token(jwttoken)
                .build();
    }
}
