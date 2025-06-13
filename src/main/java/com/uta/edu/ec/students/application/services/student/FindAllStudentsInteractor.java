package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.FindAllStudents;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;

import java.util.List;

public class FindAllStudentsInteractor implements FindAllStudents {

    private final StudentRepository studentRepository;

    public FindAllStudentsInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
