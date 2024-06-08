package dev.naimsulejmani.bankav2backend.services.impls;

import dev.naimsulejmani.bankav2backend.entities.UserEntity;
import dev.naimsulejmani.bankav2backend.infrastructure.services.impls.BaseServiceImpl;
import dev.naimsulejmani.bankav2backend.repositories.UserRepository;
import dev.naimsulejmani.bankav2backend.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
