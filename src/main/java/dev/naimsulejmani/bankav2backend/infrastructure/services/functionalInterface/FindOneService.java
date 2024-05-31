package dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface;

@FunctionalInterface
public interface FindOneService<T, Tid> {

    public T findById(Tid id);
}
