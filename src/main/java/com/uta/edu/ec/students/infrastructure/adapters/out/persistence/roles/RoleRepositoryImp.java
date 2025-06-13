package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles;

import com.uta.edu.ec.students.application.out.RoleRepository;
import com.uta.edu.ec.students.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImp implements RoleRepository {

    private final RoleRepositoryJpa repositoryJpa;

    @Override
    public Optional<Role> findByName(String name) {
        return repositoryJpa
                .findByName(name)
                .map(roleEntity -> {
                    Role role = new Role();
                    role.setId(roleEntity.getId());
                    role.setName(roleEntity.getName());
                    return role;
                });
    }
}
