package com.uta.edu.ec.students.application.in.student;

import com.uta.edu.ec.students.domain.Student;

import java.util.List;

public interface FindStudentByDniContaining {

    List<Student> find(String dni);
}
