package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.ExistsStudentByDni;
import com.uta.edu.ec.students.application.out.StudentRepository;

public class ExistsStudentByDniInteractor implements ExistsStudentByDni {

    private final StudentRepository studentRepository;

    public ExistsStudentByDniInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean exists(String dni) {
        return studentRepository.existsByDni(dni);
    }
}
