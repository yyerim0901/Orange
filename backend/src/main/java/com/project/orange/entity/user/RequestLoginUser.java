package com.project.orange.entity.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginUser {
    private String email;
    private String password;

    public RequestLoginUser(){}

    public RequestLoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
