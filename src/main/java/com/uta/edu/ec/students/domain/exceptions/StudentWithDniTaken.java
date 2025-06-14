package com.uta.edu.ec.students.domain.exceptions;

public class StudentWithDniTaken extends RuntimeException{

    public StudentWithDniTaken(String message) {
        super(message);
    }
}
