package com.uta.edu.ec.students.application.in.student;

import com.uta.edu.ec.students.domain.Student;

public interface  FindStudentByDni {

    Student find(String dni);
}
