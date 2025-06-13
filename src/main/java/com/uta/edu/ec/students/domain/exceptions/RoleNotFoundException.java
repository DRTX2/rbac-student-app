package com.uta.edu.ec.students.domain.exceptions;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(String message) {
        super(message);
    }

}
