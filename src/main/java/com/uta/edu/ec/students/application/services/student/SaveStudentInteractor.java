package com.uta.edu.ec.students.application.services.student;

import com.uta.edu.ec.students.application.in.student.SaveStudent;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;

public class SaveStudentInteractor implements SaveStudent {

    private final StudentRepository studentRepository;

    public SaveStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
