package com.uta.edu.ec.students.domain.exceptions;

public class StudentWithPhoneNumberTakenException extends RuntimeException {

    public StudentWithPhoneNumberTakenException(String message) {
        super(message);
    }
}
