package dev.naimsulejmani.bankav2backend.dtos;

import dev.naimsulejmani.bankav2backend.entities.enums.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {

    private String name;
    private String surname;
    private LocalDate birthdate;
    private Gender gender;

    @Column(unique = true)
    private String email;

    private String password;
}
