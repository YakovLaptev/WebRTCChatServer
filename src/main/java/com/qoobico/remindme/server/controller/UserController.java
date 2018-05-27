package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Event;
import com.qoobico.remindme.server.entity.Request;
import com.qoobico.remindme.server.entity.User;
import com.qoobico.remindme.server.entity.UserDTO;
import com.qoobico.remindme.server.service.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Transactional
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
    public User getUser(@PathVariable("id") long userId) {
        return service.getByID(userId);
    }

    @RequestMapping(value = "/users/get_by_email", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByEmail(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        List<User> users = service.getAll();
        for (User u : users) {
            if(u.getEmail().equals(user.getEmail())) {
                return u;
            }
        }
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        return service.save(user);
    }

    @RequestMapping(value = "/users/my_events/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getUserMyEvents(@PathVariable("id") long userId) {
        return service.getByID(userId).getMyEvents();
    }


    @RequestMapping(value = "/users/my_requests/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Request> getUserMyRequests(@PathVariable("id") long userId) {
        return service.getByID(userId).getMyRequests();
    }

    /*@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }*/

}
