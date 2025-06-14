package com.uta.edu.ec.students.infrastructure.adapters.in.student;

import com.uta.edu.ec.students.application.in.student.*;
import com.uta.edu.ec.students.application.in.user.FindAllUsers;
import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.infrastructure.adapters.in.mappers.StudentRestMapper;
import com.uta.edu.ec.students.infrastructure.adapters.in.mappers.UserRestMapper;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.StudentRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.UserRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.response.StudentResponse;
import com.uta.edu.ec.students.infrastructure.adapters.in.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentWebAdapter {

    private final FindAllStudents findAllStudents;
    private final FindStudentByDni findStudentByDni;
    private final FindStudentByDniContaining findStudentByDniContaining;
    private final SaveStudent saveStudent;
    private final UpdateStudent updateStudent;
    private final DeleteStudentByDni deleteStudentByDni;
    private final ExistsStudentByDni existsStudentByDni;
    private final ExistsStudentByEmail existsStudentByEmail;
    private final ExistsStudentByPhone existsStudentByPhone;
    private final ExistsByPhoneNumberExceptSelf existsByPhoneNumberExceptSelf;
    private final ExistsByEmailExceptSelf existsByEmailExceptSelf;

    private final FindAllUsers findAllUsers;
    private final UserRestMapper userRestMapper;

    private final StudentRestMapper mapper;
    private final StudentRestMapper studentRestMapper;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SECRETARY')")
    @GetMapping("/")
    // Recordar: Model es un contenedor (internamente un Map<String, Object>) que se pasa a la vista.
    public String findAll(Model model) {

        List<StudentResponse> studentsResponses = findAllStudents
                .findAll()
                .stream().map(studentRestMapper::toStudentResponse)
                .toList();

        List<UserResponse> usersResponses = findAllUsers
                .findAll()
                .stream().map(userRestMapper::toUserResponse)
                .toList();

        model.addAttribute("students", studentsResponses);
        model.addAttribute("users", usersResponses);

        model.addAttribute("newStudent", new StudentRequest());
        model.addAttribute("editStudent", new StudentRequest());

        model.addAttribute("newUser", new UserRequest());

        return "students/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public String save(@Valid @ModelAttribute("newStudent") StudentRequest req, BindingResult result, Model model) {

        if (existsStudentByDni.exists(req.getDni())) {
            result.rejectValue("dni", "duplicate", "Un estudiante con ese DNI ya existe");
        }

        if (existsStudentByEmail.exists(req.getEmail())) {
            result.rejectValue("email", "duplicate", "Un estudiante con ese EMAIL ya existe");
        }

        if (existsStudentByPhone.exists(req.getPhoneNumber())) {
            result.rejectValue("phoneNumber", "duplicate", "Un estudiante con ese TELEFONO ya existe");
        }

        if (result.hasErrors()) {
            model.addAttribute("students", findAllStudents.findAll().stream().map(studentRestMapper::toStudentResponse).toList());
            model.addAttribute("users", findAllUsers.findAll().stream().map(userRestMapper::toUserResponse).toList());
            model.addAttribute("editStudent", new StudentRequest());
            model.addAttribute("newUser", new UserRequest());
            model.addAttribute("openCreate", true);
            return "students/list";
        }

        Student student = mapper.toStudent(req);
        saveStudent.save(student);

        return "redirect:/students/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{dni}")
    // Recordar: ModelAttribute mapea los campos del formulario al objeto.
    // y ademas lo agrega al modelo (Model) para que pueda ser utilizado en la vista.
    public String update(@PathVariable String dni, @Valid @ModelAttribute("editStudent") StudentRequest req, BindingResult result, Model model) {
        Student found = findStudentByDni.find(dni);

        // ver si existe otro email
        if (existsByEmailExceptSelf.exists(req.getEmail(), found.getDni())) {
            result.rejectValue("email", "duplicate", "Un estudiante con ese CORREO ya existe");
        }

        // ver si existe otro telefono
        if (existsByPhoneNumberExceptSelf.exists(req.getPhoneNumber(), found.getDni())) {
            result.rejectValue("phoneNumber", "duplicate", "Un estudiante con ese TELEFONO ya existe");
        }

        if (result.hasErrors()) {
            log.info("Errors {}", result.getFieldErrors());
            model.addAttribute("students", findAllStudents.findAll().stream().map(studentRestMapper::toStudentResponse).toList());
            model.addAttribute("users", findAllUsers.findAll().stream().map(userRestMapper::toUserResponse).toList());
            model.addAttribute("newStudent", new StudentRequest());
            model.addAttribute("newUser", new UserRequest());
            model.addAttribute("openEdit", true);
            return "students/list";
        }

        found.setFirstName(req.getFirstName());
        found.setLastName(req.getLastName());
        found.setAddress(req.getAddress());
        found.setEmail(req.getEmail());
        found.setPhoneNumber(req.getPhoneNumber());
        updateStudent.update(found);

        return "redirect:/students/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{dni}")
    public String delete(@PathVariable String dni) {
        deleteStudentByDni.delete(dni);

        return "redirect:/students/";
    }

    private void loadView(Model model) {
        model.addAttribute("students", findAllStudents.findAll().stream().map(studentRestMapper::toStudentResponse).toList());
        model.addAttribute("users", findAllUsers.findAll().stream().map(userRestMapper::toUserResponse).toList());
        model.addAttribute("newUser", new UserRequest());
        model.addAttribute("newStudent", new StudentRequest());
    }
}
