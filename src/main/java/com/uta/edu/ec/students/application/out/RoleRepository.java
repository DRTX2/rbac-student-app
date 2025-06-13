package com.uta.edu.ec.students.application.out;

import com.uta.edu.ec.students.domain.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
