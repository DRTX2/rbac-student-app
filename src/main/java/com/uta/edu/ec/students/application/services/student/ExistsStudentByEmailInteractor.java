package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.ExistsStudentByEmail;
import com.uta.edu.ec.students.application.out.StudentRepository;

public class ExistsStudentByEmailInteractor implements ExistsStudentByEmail {

    private final StudentRepository repository;

    public ExistsStudentByEmailInteractor(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String email) {
        return repository.existsByEmail(email);
    }
}
