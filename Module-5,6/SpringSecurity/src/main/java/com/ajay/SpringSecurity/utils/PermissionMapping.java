package com.ajay.SpringSecurity.utils;

import com.ajay.SpringSecurity.entities.enums.Permissions;
import com.ajay.SpringSecurity.entities.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ajay.SpringSecurity.entities.enums.Permissions.*;
import static com.ajay.SpringSecurity.entities.enums.Role.*;

public class PermissionMapping {
    private static final Map<Role, Set<Permissions>> map = Map.of(
            USER,Set.of(USER_VIEW,POST_VIEW),
            CREATER,Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE),
            ADMIN, Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE,USER_DELETE,POST_DELETE,USER_CREATE)
    );
    public static Set<SimpleGrantedAuthority> getAuthoritiesForRole(Role role){
        return map.get(role).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
