package com.qoobico.remindme.server.service;

import com.qoobico.remindme.server.entity.Event;
import com.qoobico.remindme.server.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class EventServiceImpl implements Service<Event> {

    @Autowired
    private EventRepository repository;

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getByID(long id) {
        return repository.findOne(id);
    }

    public Event save(Event entity) {
        return repository.saveAndFlush(entity);
    }

    public void remove(long id) {
        repository.delete(id);
    }

}
