package com.uta.edu.ec.students.infrastructure.adapters.in.mappers;

import com.uta.edu.ec.students.domain.User;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.UserRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    @Mapping(target = "id", ignore = true) // genrado por la bd
    @Mapping(target = "roles", ignore = true) // los manejo por separado
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);
}
