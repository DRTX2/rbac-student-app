package com.uta.edu.ec.students.infrastructure.commons;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EcuadorDniValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EcuadorDni {
    String message() default "Cédula inválida para Ecuador";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
