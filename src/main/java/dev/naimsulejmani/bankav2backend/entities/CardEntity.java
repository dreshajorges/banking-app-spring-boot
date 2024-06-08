package dev.naimsulejmani.bankav2backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.naimsulejmani.bankav2backend.entities.enums.CardType;
import dev.naimsulejmani.bankav2backend.infrastructure.helpers.HasId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private LocalDate expirationDate;
    private CardType cardType;
    private double balance;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
