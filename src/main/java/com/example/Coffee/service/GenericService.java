package com.example.Coffee.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();
    T findById(Long id);
    T save(T item);
    void delete(Long id);

    boolean exist(Long id);

    void deleteAll();

}
