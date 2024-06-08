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

import java.util.List;

@RestController
@RequestMapping("/api/banka/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserEntity> deleteById(@PathVariable long id){

        return ResponseEntity.ok(userService.deleteById(id));
    }


    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){

        return ResponseEntity.ok(userService.findAll());
    }
}
