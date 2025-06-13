package com.uta.edu.ec.students.application.services.user;

import com.uta.edu.ec.students.application.in.user.UserRegistration;
import com.uta.edu.ec.students.application.out.UserRepository;
import com.uta.edu.ec.students.domain.User;

public class UserRegistrationInteractor implements UserRegistration {

    private final UserRepository repository;

    public UserRegistrationInteractor(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public User register(User user) {
        return repository.save(user);
    }
}
