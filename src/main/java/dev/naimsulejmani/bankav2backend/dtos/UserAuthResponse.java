package dev.naimsulejmani.bankav2backend.dtos;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponse {

    private String token;
}
