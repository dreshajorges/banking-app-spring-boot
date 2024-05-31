package dev.naimsulejmani.bankav2backend.entities.enums;

public enum CardType {
    SAVINGS(1),
    TRAVEL(2),
    BUSINESS(3),
    STUDENT(4);

    private final int value;

    CardType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
