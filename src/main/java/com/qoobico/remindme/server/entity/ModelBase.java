package com.qoobico.remindme.server.entity;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ModelBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}