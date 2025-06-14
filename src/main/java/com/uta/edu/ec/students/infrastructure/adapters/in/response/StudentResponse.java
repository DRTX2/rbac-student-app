package com.uta.edu.ec.students.infrastructure.adapters.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
