package com.qoobico.remindme.server.repository;

import com.qoobico.remindme.server.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
