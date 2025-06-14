package com.uta.edu.ec.students.application.out;

import com.uta.edu.ec.students.domain.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();
    Optional<Student> findByDni(String dni);
    Student save(Student student);
    void deleteByDni(String dni);
    List<Student> findByDniContaining(String dni);
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByEmailExceptSelf(String email, String selfDni);
    boolean existsByPhoneExceptSelf(String phone, String selfDni);
}
