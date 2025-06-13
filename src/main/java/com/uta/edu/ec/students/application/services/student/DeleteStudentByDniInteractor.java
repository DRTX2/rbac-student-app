package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.DeleteStudentByDni;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.exceptions.StudentNotFoundException;

public class DeleteStudentByDniInteractor implements DeleteStudentByDni {

    private final StudentRepository studentRepository;

    public DeleteStudentByDniInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void delete(String dni) {
        studentRepository.findByDni(dni).orElseThrow(() -> new StudentNotFoundException("Student not found with DNI: " + dni));
        studentRepository.deleteByDni(dni);
    }

}
