package com.qoobico.remindme.server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request extends ModelBase{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_event")
    @JsonManagedReference
    private Event event;

    public Request() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
