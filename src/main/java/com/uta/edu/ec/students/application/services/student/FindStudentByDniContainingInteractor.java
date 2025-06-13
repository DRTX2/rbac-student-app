package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.FindStudentByDniContaining;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;

import java.util.List;

public class FindStudentByDniContainingInteractor implements FindStudentByDniContaining {

    private final StudentRepository studentRepository;

    public FindStudentByDniContainingInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> find(String dni) {
        return studentRepository.findByDniContaining(dni);
    }
}
