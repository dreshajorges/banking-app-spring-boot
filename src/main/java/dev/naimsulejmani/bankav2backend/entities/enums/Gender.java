package dev.naimsulejmani.bankav2backend.entities.enums;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
