package dev.naimsulejmani.bankav2backend.dtos;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    private String email;

    private String password;
}
