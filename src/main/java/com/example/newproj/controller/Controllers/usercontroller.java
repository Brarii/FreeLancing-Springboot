package com.example.newproj.controller.Controllers;

import com.example.newproj.Entities.Entities.AuthenticationRequest;
import com.example.newproj.Entities.Entities.AuthnticationResponse;
import com.example.newproj.Entities.Entities.FreeLancer;
import com.example.newproj.Entities.Entities.Portfolio;
import com.example.newproj.Services.FreeLancerService;
import com.example.newproj.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class usercontroller {
    private  final com.example.newproj.Services.authservice authservice;
    private FreeLancerService fs;







    @PostMapping("/login")
    public  ResponseEntity<AuthnticationResponse>  loginruser
            (@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authservice.authenticate(authenticationRequest));

    }




}

