package com.uta.edu.ec.students.application.in.student;

public interface ExistsByEmailExceptSelf {

    boolean exists(String email, String selfDni);
}
