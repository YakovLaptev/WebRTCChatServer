package com.qoobico.remindme.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ModelBase implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}