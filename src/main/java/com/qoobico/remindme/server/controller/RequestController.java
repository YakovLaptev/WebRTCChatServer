package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Event;
import com.qoobico.remindme.server.entity.Request;
import com.qoobico.remindme.server.entity.User;
import com.qoobico.remindme.server.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Transactional
public class RequestController {

    @Autowired
    private Service<Request> service;
    @Autowired
    private Service<Event> event_service;

    @RequestMapping(value = "/requests/{id}/{status}", method = RequestMethod.GET)
    @ResponseBody
    public void accept(@PathVariable("id") long id, @PathVariable("status") String status) {
        Request request = service.getByID(id);
        if (status.equals("accept")) {
            Event event = request.getEvent();
            List<User> users = event.getUsers();
            users.add(request.getUser());
            event.setUsers(users);
            event_service.save(event);
        }
        service.remove(id);
    }


}
