package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.mappers;

import com.uta.edu.ec.students.domain.Role;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {

    RoleEntity toEntity(Role role);

    @Mapping(target = "users", ignore = true)
    Role toRole(RoleEntity roleEntity);
}
