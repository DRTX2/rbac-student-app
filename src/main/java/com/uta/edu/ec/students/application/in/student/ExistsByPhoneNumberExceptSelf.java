package com.uta.edu.ec.students.application.in.student;

public interface ExistsByPhoneNumberExceptSelf {

    boolean exists(String phone, String selfDni);
}
