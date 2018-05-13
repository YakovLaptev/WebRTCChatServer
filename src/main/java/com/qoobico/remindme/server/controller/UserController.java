package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Event;
import com.qoobico.remindme.server.entity.User;
import com.qoobico.remindme.server.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class UserController {

    @Autowired
    private Service<User> service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

    @RequestMapping(value = "/users/my_events/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getUserMyEvents(@PathVariable("id") long remindID) {
        return service.getByID(remindID).getMyEvents();
    }

}
