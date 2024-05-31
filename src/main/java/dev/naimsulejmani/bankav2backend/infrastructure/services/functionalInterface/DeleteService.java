package dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface;
@FunctionalInterface
public interface DeleteService<T, Tid> {

    public T deleteById(Tid id);
}
