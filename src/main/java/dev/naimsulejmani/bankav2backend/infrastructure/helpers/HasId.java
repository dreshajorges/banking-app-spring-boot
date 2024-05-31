package dev.naimsulejmani.bankav2backend.infrastructure.helpers;

@FunctionalInterface
public interface HasId<Tid> {

    public Tid getId();
}
