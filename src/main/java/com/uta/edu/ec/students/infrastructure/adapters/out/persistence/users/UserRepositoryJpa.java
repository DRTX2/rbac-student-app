package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {

    @Query("select u from UserEntity u join fetch u.roles where u.username = ?1")
    Optional<UserEntity> findByUsername(String username);
}
