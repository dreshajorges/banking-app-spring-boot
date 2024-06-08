package dev.naimsulejmani.bankav2backend.services.impls;

import dev.naimsulejmani.bankav2backend.configs.authentication.JwtService;
import dev.naimsulejmani.bankav2backend.dtos.UserAuthResponse;
import dev.naimsulejmani.bankav2backend.dtos.UserLoginRequest;
import dev.naimsulejmani.bankav2backend.dtos.UserRegisterRequest;
import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import dev.naimsulejmani.bankav2backend.entities.enums.Roles;
import dev.naimsulejmani.bankav2backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserAuthResponse register(UserRegisterRequest request) {

        boolean isFirstUser = repository.count() == 0;


        Roles role = isFirstUser ? Roles.ADMIN : Roles.USER;

        var user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birthdate(request.getBirthdate())
                .gender(request.getGender())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return UserAuthResponse.builder()
                .token(jwtToken)
                .build();
    }


    public UserAuthResponse login(UserLoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return UserAuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
