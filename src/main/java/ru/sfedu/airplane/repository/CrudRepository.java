package ru.sfedu.airplane.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    <S extends T> S save(S var1);
    <S extends T> List<S> saveAll(List<S> var1);
    Optional<T> findById(ID var1);
    boolean existsById(ID var1);
    List<T> findAll();
    List<T> findAllById(List<ID> var1);
    long count();
    void deleteById(ID var1);
    void delete(T var1);
    void deleteAll(List<? extends T> var1);
    void deleteAll();
}
