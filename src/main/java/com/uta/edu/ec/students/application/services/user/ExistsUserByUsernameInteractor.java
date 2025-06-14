package com.uta.edu.ec.students.application.services.user;

import com.uta.edu.ec.students.application.in.user.ExistsUserByUsername;
import com.uta.edu.ec.students.application.out.UserRepository;

public class ExistsUserByUsernameInteractor implements ExistsUserByUsername {

    private final UserRepository userRepository;

    public ExistsUserByUsernameInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean exists(String username) {
        return userRepository.existsByUsername(username);
    }
}
