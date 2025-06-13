package com.uta.edu.ec.students.application.services.user;

import com.uta.edu.ec.students.application.in.user.FindAllUsers;
import com.uta.edu.ec.students.application.out.UserRepository;
import com.uta.edu.ec.students.application.services.student.FindAllStudentsInteractor;
import com.uta.edu.ec.students.domain.User;

import java.util.List;

public class FindAllUsersInteractor implements FindAllUsers {

    private final UserRepository userRepository;

    public FindAllUsersInteractor(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
