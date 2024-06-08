package dev.naimsulejmani.bankav2backend.dtos;

import dev.naimsulejmani.bankav2backend.entities.enums.Gender;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    private String name;
    private String surname;
    private LocalDate birthdate;
    private Gender gender;

    @Column(unique = true)
    private String email;

    private String password;
}
