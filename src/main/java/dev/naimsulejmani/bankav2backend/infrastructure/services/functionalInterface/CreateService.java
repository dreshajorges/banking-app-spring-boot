package dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface;

@FunctionalInterface
public interface CreateService<T> {
    public T add(T item);
}
