package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.student;

import com.uta.edu.ec.students.infrastructure.commons.EcuadorDni;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @EcuadorDni
    @Column(length = 10)
    private String dni;

    @Column(name = "first_name", length =  50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length =  50, nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "El correo no tiene un formato válido"
    )
    private String email;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String address;
}
