package com.uta.edu.ec.students.domain.exceptions;

public class StudentWithEmailTakenException extends RuntimeException {

    public StudentWithEmailTakenException(String message) {
        super(message);
    }


}


