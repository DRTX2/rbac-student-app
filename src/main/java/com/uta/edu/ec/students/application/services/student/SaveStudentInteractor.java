package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.SaveStudent;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.domain.exceptions.StudentWithDniTaken;
import com.uta.edu.ec.students.domain.exceptions.StudentWithEmailTakenException;
import com.uta.edu.ec.students.domain.exceptions.StudentWithPhoneNumberTakenException;

public class SaveStudentInteractor implements SaveStudent {

    private final StudentRepository studentRepository;

    public SaveStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {

        if (studentRepository.existsByDni(student.getDni())) {
            throw new StudentWithDniTaken("Dni existente");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new StudentWithEmailTakenException("Email existente");
        }

        if (studentRepository.existsByPhone(student.getPhoneNumber())) {
            throw new StudentWithPhoneNumberTakenException("Telefono existente");
        }

        return studentRepository.save(student);
    }
}
