package com.qoobico.remindme.server.repository;

import com.qoobico.remindme.server.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
