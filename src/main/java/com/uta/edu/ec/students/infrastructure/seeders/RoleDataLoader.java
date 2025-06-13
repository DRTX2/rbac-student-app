package com.uta.edu.ec.students.infrastructure.seeders;

import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleEntity;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleDataLoader implements CommandLineRunner {

    private final RoleRepositoryJpa jpa;

    @Override
    public void run(String... args) throws Exception {

        if (jpa.count() == 0) {

            RoleEntity admin = new RoleEntity();
            admin.setName("ROLE_ADMIN");

            RoleEntity secretary = new RoleEntity();
            secretary.setName("ROLE_SECRETARY");

            jpa.saveAll(List.of(admin, secretary));

        }
    }
}
