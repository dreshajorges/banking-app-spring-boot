package dev.naimsulejmani.bankav2backend.services.impls;

import dev.naimsulejmani.bankav2backend.configs.authentication.JwtService;
import dev.naimsulejmani.bankav2backend.entities.CardEntity;
import dev.naimsulejmani.bankav2backend.infrastructure.services.impls.BaseServiceImpl;
import dev.naimsulejmani.bankav2backend.repositories.CardRepository;
import dev.naimsulejmani.bankav2backend.repositories.UserRepository;
import dev.naimsulejmani.bankav2backend.services.CardsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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

@Override
    public void sendMoney(String senderCardNumber, String recipientCardNumber, double amount) {
        // Step 1: Fetch sender's card entity from database
        Optional<CardEntity> optionalSenderCard = ((CardRepository) repository).findByCardNumber(senderCardNumber);
        if (optionalSenderCard.isEmpty()) {
            throw new IllegalArgumentException("Sender card not found");
        }
        CardEntity senderCard = optionalSenderCard.get();

        // Step 2: Fetch recipient's card entity from database
        Optional<CardEntity> optionalRecipientCard = ((CardRepository) repository).findByCardNumber(recipientCardNumber);
        if (optionalRecipientCard.isEmpty()) {
            throw new IllegalArgumentException("Recipient card not found");
        }
        CardEntity recipientCard = optionalRecipientCard.get();

        // Step 3: Check if sender has sufficient balance
        if (senderCard.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in sender's account");
        }

        // Step 4: Perform the money transfer
        senderCard.setBalance(senderCard.getBalance() - amount);
        recipientCard.setBalance(recipientCard.getBalance() + amount);

        // Step 5: Update both card entities in the database
        repository.save(senderCard);
        repository.save(recipientCard);
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
