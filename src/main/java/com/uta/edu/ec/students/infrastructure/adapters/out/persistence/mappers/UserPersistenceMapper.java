package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.mappers;

import com.uta.edu.ec.students.domain.User;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.users.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RolePersistenceMapper.class})
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);


    User toUser(UserEntity userEntity);
}
