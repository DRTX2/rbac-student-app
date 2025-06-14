package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.ExistsStudentByPhone;
import com.uta.edu.ec.students.application.out.StudentRepository;

public class ExistsStudentByPhoneInteractor implements ExistsStudentByPhone {

    private final StudentRepository repository;

    public ExistsStudentByPhoneInteractor(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String phone) {
        return repository.existsByPhone(phone);
    }
}
