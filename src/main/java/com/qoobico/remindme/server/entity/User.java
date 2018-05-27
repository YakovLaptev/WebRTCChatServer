package com.qoobico.remindme.server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends ModelBase{

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "avatar", length = 50)
    private String avatar;

    @Column(name = "about", length = 50)
    private String about;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "creator")
    @JsonBackReference
    private List<Event> myEvents = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @JsonBackReference
    private List<Event> events = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonBackReference
    private List<Request> myRequests = new ArrayList<>();

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Event> getMyEvents() {
        return myEvents;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setMyEvents(List<Event> myEvents) {
        this.myEvents = myEvents;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Request> getMyRequests() {
        return myRequests;
    }

    public void setMyRequests(List<Request> myRequests) {
        this.myRequests = myRequests;
    }
}
