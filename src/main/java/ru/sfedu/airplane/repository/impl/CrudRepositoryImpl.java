package ru.sfedu.airplane.repository.impl;

import org.hibernate.engine.spi.SessionImplementor;
import ru.sfedu.airplane.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CrudRepositoryImpl<T, ID> implements CrudRepository<T, ID> {

    @PersistenceContext(unitName = "persistenceUnit")
    protected EntityManager entityManager;

//    @Inject @Any
//    private Instance<T> tInstance;
//    @Inject @Any
//    private Instance<ID> idInstance;

    @Override
    @Transactional
    public <S extends T> S save(S var1) {
        if (!isNew(var1)) {
            return entityManager.merge(var1);
        }
        entityManager.persist(var1);
        return var1;
    }

    @Override
    @Transactional
    public <S extends T> List<S> saveAll(List<S> var1) {
        return var1.stream().map(this::save).collect(Collectors.toList());
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
    @Transactional
    public void delete(T var1) {
        entityManager.remove(var1);
    }

    @Override
    @Transactional
    public void deleteAll(List<? extends T> var1) {
        var1.forEach(this::delete);
    }

    @Override
    public void deleteAll() {

    }

    protected boolean isNew(T var1) {
        return ((SessionImplementor) entityManager.getDelegate()).getPersistenceContext().getEntry(var1) == null;
    }


}
