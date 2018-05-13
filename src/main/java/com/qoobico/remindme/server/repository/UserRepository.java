package com.qoobico.remindme.server.repository;

import com.qoobico.remindme.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
