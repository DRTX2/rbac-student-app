package com.uta.edu.ec.students.infrastructure.commons;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EcuadorDniValidator implements ConstraintValidator<EcuadorDni, String> {
    @Override
    public boolean isValid(String dni, ConstraintValidatorContext constraintValidatorContext) {
        if (dni == null || dni.length() != 10) return false;
        if (!dni.matches("\\d{10}")) return false;

        int provincia = Integer.parseInt(dni.substring(0, 2));
        if (provincia < 1 || provincia > 24) return false;

        int tercer = Character.getNumericValue(dni.charAt(2));
        if (tercer > 5) return false;

        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int d = Character.getNumericValue(dni.charAt(i));
            int aux = ((i + 1) % 2 != 0) ? d * 2 : d;
            if (aux > 9) aux -= 9;
            suma += aux;
        }

        int mod = suma % 10;
        int verif = (mod == 0) ? 0 : 10 - mod;
        return verif == Character.getNumericValue(dni.charAt(9));
    }
}
