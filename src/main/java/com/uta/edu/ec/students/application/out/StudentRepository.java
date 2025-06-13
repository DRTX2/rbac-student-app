package com.uta.edu.ec.students.application.out;

import com.uta.edu.ec.students.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();
    Optional<Student> findByDni(String dni);
    Student save(Student student);
    void deleteByDni(String dni);
    List<Student> findByDniContaining(String dni);
}
