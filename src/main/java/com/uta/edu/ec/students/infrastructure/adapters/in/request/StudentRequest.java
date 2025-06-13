package com.uta.edu.ec.students.infrastructure.adapters.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}
