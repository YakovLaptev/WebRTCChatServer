package com.qoobico.remindme.server.service;

import com.qoobico.remindme.server.entity.Request;
import com.qoobico.remindme.server.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class RequestServiceImpl implements Service<Request> {

    @Autowired
    private RequestRepository repository;

    public List<Request> getAll() {
        return repository.findAll();
    }

    public Request getByID(long id) {
        return repository.findOne(id);
    }

    public Request save(Request entity) {
        return repository.saveAndFlush(entity);
    }

    public void remove(long id) {
        repository.delete(id);
    }

}
