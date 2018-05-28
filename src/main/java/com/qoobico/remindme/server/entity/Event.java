package com.qoobico.remindme.server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends ModelBase{

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "about", length = 50)
    private String about;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User creator;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "event_user",
            joinColumns = { @JoinColumn(name = "event_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
    @JsonManagedReference
    private List<User> users = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
    @JsonBackReference
    private List<Request> requests = new ArrayList<>();

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
