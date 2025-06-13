package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.FindStudentByDni;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.domain.exceptions.StudentNotFoundException;

public class FindStudentByDniInteractor implements FindStudentByDni {

    private final StudentRepository studentRepository;

    public FindStudentByDniInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student find(String dni) {
        return studentRepository.findByDni(dni).orElseThrow(() -> new StudentNotFoundException("Student not found with DNI: " + dni));
    }
}
