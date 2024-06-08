package dev.naimsulejmani.bankav2backend.controllers;

import dev.naimsulejmani.bankav2backend.dtos.UserAuthResponse;
import dev.naimsulejmani.bankav2backend.dtos.UserLoginRequest;
import dev.naimsulejmani.bankav2backend.dtos.UserRegisterRequest;
import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import dev.naimsulejmani.bankav2backend.services.UserService;
import dev.naimsulejmani.bankav2backend.services.impls.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banka/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<UserAuthResponse> register(@RequestBody UserRegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> login(@RequestBody UserLoginRequest request) {

        return ResponseEntity.ok(authService.login(request));

    }
}
