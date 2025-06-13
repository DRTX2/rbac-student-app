package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryJpa extends JpaRepository<StudentEntity, String> {

    // Method to find students by a partial match on their DNI
    List<StudentEntity> findByDniContaining(String dni);

}
