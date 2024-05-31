package dev.naimsulejmani.bankav2backend.infrastructure.exceptions;

public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException() {
    }

    public NotAuthorizedException(String message) {
        super(message);
    }
}
