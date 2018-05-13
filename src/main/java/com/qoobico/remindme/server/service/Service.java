package com.qoobico.remindme.server.service;

import java.util.List;

public interface Service<T> {

    List<T> getAll();
    T getByID(long id);
    T save(T entity);
    void remove(long id);

}
