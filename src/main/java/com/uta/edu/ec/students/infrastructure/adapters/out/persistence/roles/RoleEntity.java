package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles;

import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
}
