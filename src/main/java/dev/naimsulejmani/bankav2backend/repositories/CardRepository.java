package dev.naimsulejmani.bankav2backend.repositories;

import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity,Long> {

    Optional<CardEntity> findByCardNumber(String cardNumber);
}
