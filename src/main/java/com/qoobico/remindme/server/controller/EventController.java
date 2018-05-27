package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Event;
import com.qoobico.remindme.server.entity.EventDTO;
import com.qoobico.remindme.server.entity.User;
import com.qoobico.remindme.server.service.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Transactional
public class EventController {

    @Autowired
    private Service<Event> service;
    @Autowired
    private Service<User> user_service;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getAllEvents() {
        return service.getAll();
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Event getEvent(@PathVariable("id") long id) {
        return service.getByID(id);
    }


    @RequestMapping(value = "/events/subscribe/{event_id}/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public Event subscribe(@PathVariable("event_id") long event_id, @PathVariable("user_id") long user_id) {
        Event event = service.getByID(event_id);
        List<User> users = event.getUsers();
        users.add(user_service.getByID(user_id));
        event.setUsers(users);
        return service.save(event);
    }

    @RequestMapping(value = "/events/unsubscribe/{event_id}/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public Event unsubscribe(@PathVariable("event_id") long event_id, @PathVariable("user_id") long user_id) {
        Event event = service.getByID(event_id);
        List<User> users = event.getUsers();
        users.remove(user_service.getByID(user_id));
        event.setUsers(users);
        return service.save(event);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    @ResponseBody
    public Event saveEvent(@RequestBody EventDTO EventDTO) {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = new ArrayList<>();
        Event event = modelMapper.map(EventDTO, Event.class);
        users.add(event.getCreator());
        return service.save(event);
    }

    /*@RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }*/

}
