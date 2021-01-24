package com.romanbielyi.dao.interfaces;

import java.util.List;

public interface CRUD <T>{
    T findById(int id);

    List<T> findAll();

    void save(T entity);

    void delete(T entity);

    void update(T entity);
}
