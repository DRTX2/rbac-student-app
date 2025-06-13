package com.uta.edu.ec.students.application.services.role;

import com.uta.edu.ec.students.application.in.role.FindRoleByName;
import com.uta.edu.ec.students.application.out.RoleRepository;
import com.uta.edu.ec.students.domain.Role;
import com.uta.edu.ec.students.domain.exceptions.RoleNotFoundException;

public class FindRoleByNameInteractor implements FindRoleByName {

    private final RoleRepository roleRepository;

    public FindRoleByNameInteractor(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role find(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RoleNotFoundException("Role not found with name: " + name));
    }
}
