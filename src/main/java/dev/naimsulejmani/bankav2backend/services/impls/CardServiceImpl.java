package dev.naimsulejmani.bankav2backend.services.impls;

import dev.naimsulejmani.bankav2backend.configs.authentication.JwtService;
import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import dev.naimsulejmani.bankav2backend.infrastructure.services.impls.BaseServiceImpl;
import dev.naimsulejmani.bankav2backend.repositories.CardRepository;
import dev.naimsulejmani.bankav2backend.repositories.UserRepository;
import dev.naimsulejmani.bankav2backend.services.CardsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CardServiceImpl extends BaseServiceImpl<CardEntity, Long> implements CardsService {
    public CardServiceImpl(CardRepository repository, UserRepository userRepository, JwtService jwtService) {
        super(repository);
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public CardEntity add(CardEntity item) {

        item.setCardNumber(generateRandom16DigitNumber());
        item.setExpirationDate(LocalDate.now().plusYears(5));
        item.setCreatedAt(LocalDate.now());
        return super.add(item);
    }




    private String generateRandom16DigitNumber() {
        StringBuilder random16Digits = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomDigit = (int) (Math.random() * 10);
            random16Digits.append(randomDigit);
        }
        return random16Digits.toString();
    }
}
