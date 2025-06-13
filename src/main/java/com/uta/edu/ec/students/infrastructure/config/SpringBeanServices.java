package com.uta.edu.ec.students.infrastructure.config;

import com.uta.edu.ec.students.application.in.role.FindRoleByName;
import com.uta.edu.ec.students.application.in.student.*;
import com.uta.edu.ec.students.application.in.user.FindAllUsers;
import com.uta.edu.ec.students.application.in.user.UserRegistration;
import com.uta.edu.ec.students.application.out.RoleRepository;
import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.application.out.UserRepository;
import com.uta.edu.ec.students.application.services.role.FindRoleByNameInteractor;
import com.uta.edu.ec.students.application.services.student.*;
import com.uta.edu.ec.students.application.services.user.FindAllUsersInteractor;
import com.uta.edu.ec.students.application.services.user.UserRegistrationInteractor;
import org.hibernate.annotations.processing.Find;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringBeanServices {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FindAllStudents findAllStudents(StudentRepository studentRepository) {
        return new FindAllStudentsInteractor(studentRepository);
    }

    @Bean
    public FindStudentByDniContaining findStudentByDniContaining(StudentRepository studentRepository) {
        return new FindStudentByDniContainingInteractor(studentRepository);
    }

    @Bean
    public SaveStudent saveStudent(StudentRepository studentRepository) {
        return new SaveStudentInteractor(studentRepository);
    }

    @Bean
    public DeleteStudentByDni deleteStudentByDni(StudentRepository studentRepository) {
        return new DeleteStudentByDniInteractor(studentRepository);
    }

    @Bean
    public FindStudentByDni findStudentByDni(StudentRepository studentRepository) {
        return new FindStudentByDniInteractor(studentRepository);
    }

    @Bean
    public UserRegistration userRegistration(UserRepository userRepository) {
        return new UserRegistrationInteractor(userRepository);
    }

    @Bean
    public FindRoleByName findRoleByName(RoleRepository roleRepository) {
        return new FindRoleByNameInteractor(roleRepository);
    }

    @Bean
    public FindAllUsers findAllUsers(UserRepository userRepository) {
        return new FindAllUsersInteractor(userRepository);
    }
}
