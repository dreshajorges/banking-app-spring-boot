package dev.naimsulejmani.bankav2backend.repositories;

import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
