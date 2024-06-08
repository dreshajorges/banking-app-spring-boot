package dev.naimsulejmani.bankav2backend.repositories;

import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}
