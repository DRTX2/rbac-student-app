package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users;

import com.uta.edu.ec.students.application.out.UserRepository;
import com.uta.edu.ec.students.domain.User;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.mappers.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImp implements UserRepository {

    private final PasswordEncoder passwordEncoder;
    private final UserRepositoryJpa repositoryJpa;
    private final UserPersistenceMapper mapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.toUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toUser(repositoryJpa.save(userEntity));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repositoryJpa.findByUsername(username)
                .map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return repositoryJpa.findAll().stream().map(mapper::toUser).toList();
    }


}
