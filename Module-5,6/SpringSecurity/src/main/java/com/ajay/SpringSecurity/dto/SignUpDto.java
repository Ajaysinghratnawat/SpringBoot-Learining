package com.ajay.SpringSecurity.dto;

import com.ajay.SpringSecurity.entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {
        private String email;
    private String password;
    private String name;
    private Set<Role> roles;
}
