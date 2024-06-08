package dev.naimsulejmani.bankav2backend.controllers;

import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import dev.naimsulejmani.bankav2backend.services.CardsService;
import dev.naimsulejmani.bankav2backend.services.impls.CardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banka/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardsService service;

    @PostMapping
    public ResponseEntity<CardEntity> addCard(@RequestBody CardEntity card){
        return ResponseEntity.ok(service.add(card));
    }

    @GetMapping
    public ResponseEntity<List<CardEntity>> getCards(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CardEntity> getCardById(@PathVariable long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
