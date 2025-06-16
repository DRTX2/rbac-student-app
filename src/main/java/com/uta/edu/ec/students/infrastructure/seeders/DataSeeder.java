package com.uta.edu.ec.students.infrastructure.seeders;

import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleEntity;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleRepositoryJpa;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users.UserEntity;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users.UserRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepositoryJpa userRepository;
    private final RoleRepositoryJpa roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String password = "admin123456789";
    private final RoleRepositoryJpa jpa;

    @Override
    public void run(String... args) throws Exception {

        if (jpa.count() == 0) {

            RoleEntity admin = new RoleEntity();
            admin.setName("ROLE_ADMIN");

            RoleEntity secretary = new RoleEntity();
            secretary.setName("ROLE_SECRETARY");

            jpa.saveAll(List.of(admin, secretary));

            seedUser();
        }
    }

    public void seedUser() {
        if (userRepository.count() == 0) {
            UserEntity user = new UserEntity();
            user.setUsername("admin@hotmail.com");
            user.setPassword(passwordEncoder.encode(password));
            RoleEntity admin = roleRepository.findByName("ROLE_ADMIN").orElseThrow(() -> new RuntimeException("Role not found."));
            user.setRoles(List.of(admin));
            userRepository.save(user);
        }
    }


}
