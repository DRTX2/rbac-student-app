package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.ExistsByEmailExceptSelf;
import com.uta.edu.ec.students.application.out.StudentRepository;

public class ExistsByEmailExceptSelfInteractor implements ExistsByEmailExceptSelf {

    private final StudentRepository studentRepository;

    public ExistsByEmailExceptSelfInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean exists(String email, String selfDni) {
        return studentRepository.existsByEmailExceptSelf(email, selfDni);
    }
}
