package dev.naimsulejmani.bankav2backend.infrastructure.services;


import dev.naimsulejmani.bankav2backend.infrastructure.services.functionalInterface.*;

public interface BaseService<T, Tid> extends CreateService<T>, ModifyService<T,Tid>, DeleteService<T, Tid>, FindOneService<T,Tid>, FindAllService<T> {
}
