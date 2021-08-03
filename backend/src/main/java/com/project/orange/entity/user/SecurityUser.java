package com.project.orange.entity.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUiD = 1L;

    public SecurityUser(Users user){
        super(user.getUsername(),"{noop}"+ user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
    }

}
