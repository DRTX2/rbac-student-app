package com.uta.edu.ec.students.infrastructure.adapters.in.user;

import com.uta.edu.ec.students.application.in.role.FindRoleByName;
import com.uta.edu.ec.students.application.in.user.UserRegistration;
import com.uta.edu.ec.students.domain.Role;
import com.uta.edu.ec.students.domain.User;
import com.uta.edu.ec.students.infrastructure.adapters.in.mappers.UserRestMapper;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.UserRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class UserRestAdapter {

    private final UserRegistration registration;
    private final UserRestMapper mappper;

    private final FindRoleByName findRoleByName;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SECRETARY')")
    @PostMapping("/")
    public String registerUser(@Valid @ModelAttribute UserRequest req) {

        List<Role> roles = new ArrayList<>();
        if (req.isAdmin()) {
            Role role = findRoleByName.find("ROLE_ADMIN");
            roles.add(role);
        }
        if (req.isSecretary()) {
            Role role = findRoleByName.find("ROLE_SECRETARY");
            roles.add(role);
        }

        User mapped = mappper.toUser(req);
        mapped.setRoles(roles);

        registration.register(mapped);
        return "redirect:/students/";
    }

}
