package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.UpdateStudent;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;

public class UpdateStudentInteractor implements UpdateStudent {

    private final StudentRepository studentRepository;

    public UpdateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // No deberia asumir que el email y el phone ya estan validados
    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }
}
