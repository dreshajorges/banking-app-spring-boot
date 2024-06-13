package dev.naimsulejmani.bankav2backend.services.impls;

import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import dev.naimsulejmani.bankav2backend.infrastructure.exceptions.NotFoundException;
import dev.naimsulejmani.bankav2backend.infrastructure.services.impls.BaseServiceImpl;
import dev.naimsulejmani.bankav2backend.repositories.UserRepository;
import dev.naimsulejmani.bankav2backend.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserEntity modify(Long id, UserEntity userEntity) {
        Optional<UserEntity> existingUserOptional = repository.findById(id);
        if (existingUserOptional.isEmpty()) {
            throw new NotFoundException("User with ID " + id + " not found");
        }

        UserEntity existingUser = existingUserOptional.get();

        existingUser.setEmail(userEntity.getEmail());

        // Check if the password is not null and then encode it
        if (userEntity.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
            existingUser.setPassword(encodedPassword);
        }

        return repository.save(existingUser);
    }

}
