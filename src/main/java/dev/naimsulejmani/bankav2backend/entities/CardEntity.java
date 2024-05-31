package dev.naimsulejmani.bankav2backend.entities;

import dev.naimsulejmani.bankav2backend.entities.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {

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
    private UserEntity user;
}
