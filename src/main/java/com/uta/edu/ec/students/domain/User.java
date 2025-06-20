package com.uta.edu.ec.students.domain;

import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.roles.RoleEntity;

import java.util.List;

public class User {

    private Long id;
    private String username;
    private String password;
    public List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
