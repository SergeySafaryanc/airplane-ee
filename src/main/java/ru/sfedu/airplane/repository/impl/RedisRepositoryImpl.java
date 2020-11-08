package ru.sfedu.airplane.repository.impl;

import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.redis.key.RedisBucketManagerFactory;
import ru.sfedu.airplane.repository.CrudRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public abstract class RedisRepositoryImpl<T, ID> implements CrudRepository<T, ID> {

    RedisBucketManagerFactory factory;
    BucketManager bucketManager;


    @Override
    public <S extends T> S save(S var1) {
//        bucketManager.get();
//        RedisConnection connection = client.connect();
//        connection.
        return null;
    }

    @Override
    public <S extends T> List<S> saveAll(List<S> var1) {
        return null;
    }

    @Override
    public Optional<T> findById(ID var1) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID var1) {
        return false;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findAllById(List<ID> var1) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID var1) {

    }

    @Override
    public void delete(T var1) {

    }

    @Override
    public void deleteAll(List<? extends T> var1) {

    }

    @Override
    public void deleteAll() {

    }
}
