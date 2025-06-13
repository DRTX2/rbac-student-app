package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles;

import com.uta.edu.ec.students.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositoryJpa extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(String name);
}
