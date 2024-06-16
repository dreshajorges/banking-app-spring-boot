package dev.naimsulejmani.bankav2backend.services;

import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import dev.naimsulejmani.bankav2backend.infrastructure.services.BaseService;
import org.springframework.stereotype.Service;


public interface CardsService extends BaseService<CardEntity, Long> {

    void sendMoney(String senderCardNumber, String recipientCardNumber, double amount);
}
