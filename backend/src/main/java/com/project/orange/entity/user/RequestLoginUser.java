package com.project.orange.entity.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginUser {
    private String nickname;
    private String password;

    public RequestLoginUser(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
