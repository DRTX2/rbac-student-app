package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.ExistsByPhoneNumberExceptSelf;
import com.uta.edu.ec.students.application.out.StudentRepository;

public class ExistsByPhoneNumberExceptSelfInteractor implements ExistsByPhoneNumberExceptSelf {

    private final StudentRepository studentRepository;

    public ExistsByPhoneNumberExceptSelfInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean exists(String phone, String selfDni) {
        return studentRepository.existsByPhoneExceptSelf(phone, selfDni);
    }
}
