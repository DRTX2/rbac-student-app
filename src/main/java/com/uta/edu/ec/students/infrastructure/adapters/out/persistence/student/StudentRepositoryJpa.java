package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryJpa extends JpaRepository<StudentEntity, String> {

    // Method to find students by a partial match on their DNI
    List<StudentEntity> findByDniContaining(String dni);

    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumberAndDniNot(String phoneNumber, String dni);
    boolean existsByEmailAndDniNot(String email, String dni);
}
