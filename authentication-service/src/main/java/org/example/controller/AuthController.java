package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.entity.AuthRequest;
import org.example.entity.AuthResponce;
import org.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponce> register(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
