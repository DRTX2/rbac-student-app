package com.uta.edu.ec.students.infrastructure.adapters.in.user;

import com.uta.edu.ec.students.application.in.role.FindRoleByName;
import com.uta.edu.ec.students.application.in.student.FindAllStudents;
import com.uta.edu.ec.students.application.in.student.FindStudentByDni;
import com.uta.edu.ec.students.application.in.user.ExistsUserByUsername;
import com.uta.edu.ec.students.application.in.user.FindAllUsers;
import com.uta.edu.ec.students.application.in.user.UserRegistration;
import com.uta.edu.ec.students.domain.Role;
import com.uta.edu.ec.students.domain.User;
import com.uta.edu.ec.students.infrastructure.adapters.in.mappers.StudentRestMapper;
import com.uta.edu.ec.students.infrastructure.adapters.in.mappers.UserRestMapper;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.StudentRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class UserWebAdapter {

    private final UserRegistration registration;
    private final FindAllStudents findAllStudents;
    private final FindAllUsers findAllUsers;
    private final UserRestMapper mappper;
    private final ExistsUserByUsername existsUserByUsername;
    private final StudentRestMapper studentRestMapper;
    private final UserRestMapper userRestMapper;
    private final FindRoleByName findRoleByName;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SECRETARY')")
    @PostMapping("/")
    public String registerUser(@Valid @ModelAttribute("newUser") UserRequest req, BindingResult result, Model model) {

        if (existsUserByUsername.exists(req.getUsername())) {
            result.rejectValue("username", "duplicate", "Un usuario con ese CORREO ya existe");
        }

        if (result.hasErrors()) {
            model.addAttribute("students", findAllStudents.findAll().stream().map(studentRestMapper::toStudentResponse).toList());
            model.addAttribute("users", findAllUsers.findAll().stream().map(userRestMapper::toUserResponse).toList());
            model.addAttribute("newStudent", new StudentRequest());
            model.addAttribute("editStudent", new StudentRequest());
            model.addAttribute("openCreateUser", true);
            return "students/list";
        }

        // lo mejor seria utilizar una lsita (como se mecniono en el user request), iterar esa lista
        // y en base a ese rol que venga (convencion) buscarlo y luego agregarlo al usuario.
        List<Role> roles = new ArrayList<>();
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
