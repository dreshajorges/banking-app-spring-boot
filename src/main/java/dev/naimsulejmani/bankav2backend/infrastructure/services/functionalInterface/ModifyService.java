package dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface;

@FunctionalInterface
public interface ModifyService<T, Tid> {

    public T modify(Tid id, T item);
}
