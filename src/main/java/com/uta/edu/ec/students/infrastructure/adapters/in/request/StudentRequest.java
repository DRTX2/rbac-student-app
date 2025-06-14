package com.uta.edu.ec.students.infrastructure.adapters.in.request;

import com.uta.edu.ec.students.infrastructure.commons.EcuadorDni;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @EcuadorDni
    @NotBlank(message = "La cédula es obligatoria")
    @Size(min = 10,max = 10, message = "Debe tener exactamente 10 caracteres")
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String lastName;

    @NotBlank(message = "El correo es obligatorio")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Formato de correo inválido")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp ="^\\d{10}$", message = "Teléfono debe tener 10 dígitos")
    private String phoneNumber;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String address;
}
