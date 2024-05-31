package dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface;

import java.util.List;

@FunctionalInterface
public interface FindAllService<T> {
    public List<T> findAll();
}
