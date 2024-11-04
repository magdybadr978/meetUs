package com.example.app.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T, Id> extends JpaRepository<T, Id> {

    default T create(T entity) {
        return save(entity);
    }

    default Optional<T> findOne(Id id) {
        return findById(id);
    }

    default List<T> getAll() {
        return findAll();
    }

    default void deleteOne(Id id) {
        deleteById(id);
    }

    default T update(T entity) {
        return save(entity);
    }
}
