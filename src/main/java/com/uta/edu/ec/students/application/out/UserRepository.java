package com.uta.edu.ec.students.application.out;

import com.uta.edu.ec.students.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    boolean existsByUsername(String username);
}

